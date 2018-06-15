## Why is work stealing only implemented in ForkJoinTask.join() and not in any other blocking methods in the Java API? 

There are many blocking methods (Object.wait(), Future.get(), any of the concurrency primitives in java.util.concurrent, I/O methods etc), 
and they have nothing to do with ForkJoinPool, which is just an arbitrary class in the API, so adding special cases to all these methods would be bad design. 
It would also lead to possibly very surprising and undesired effects. Imagine for example a user passing a task to an ExecutorService that waits on a Future, and then finding out that 
the task hangs very long in Future.get() just because the running thread stole some other (long-running) work item instead of waiting for the Future and 
continuing immediately after the result is available. Once a thread starts working on another task, it cannot return to the original task until the second task is finished. 
Thus it is actually a good thing that other blocking methods do not do work stealing. **For a ForkJoinTask, this problem does not exist**, because it is not important that the primary task 
is continued as soon as possible, it is only important that all tasks together are handled as efficiently as possible.

It is also not possible to implement your own method for doing work stealing inside a ForkJoinPool, because all the relevant parts are not public.

## Managed Blocking
However, there is actually a second method how starvation deadlocks can be prevented. This is called managed blocking. It does not use work stealing (to avoid the problem mentioned above), 
but also needs the thread that is going to be block to actively cooperate with the thread pool. With managed blocking, the thread tells the thread pool that it may be 
blocked before it calls the potentially blocking method, and also informs the pool when the blocking method is finished. The thread pool then knows that there is a risk of a 
starvation deadlock, and may spawn additional threads if all of its threads are currently in some blocking operation and there are still other tasks to execute. 
Note that this is less efficient than work stealing, because of the overhead of the additional threads. If you implement a recursive parallel algorithm with ordinary futures and 
managed blocking instead of with ForkJoinTask and work stealing, the number of additional threads can get very large (because in the "divide" phase of the algorithm, 
a lot of tasks will be created and given to threads that immediately block and wait for results from sub-tasks).
However, a starvation deadlock is still prevented, and it avoids the problem that a task has to wait a long time because its thread started working on another task in the mean time.

The ForkJoinPool of Java also supports managed blocking. To use this, one needs to implement the interface **ForkJoinPool.ManagedBlocker** such that the potentially-blocking method that 
the task wants to execute is called from within the block method of this interface. Then the task may not call the blocking method directly, but instead needs to call 
the static method ForkJoinPool.managedBlock(ManagedBlocker). This method handles the communication with the thread pool before and after the blocking. 
It also works if the current task is not executed within a ForkJoinPool, then it just calls the blocking method.

Java 7 API that actually uses managed blocking is the class Phaser. (This class is a synchronization barrier like mutexes and latches, but more flexible and powerful.) 
So synchronizing with a Phaser inside a ForkJoinPool task should use managed blocking and can avoid starvation deadlocks 
(but ForkJoinTask.join() is still preferable because it uses work stealing instead of managed blocking). This works regardless of whether you use the ForkJoinPool 
directly or via its ExecutorService interface. However, it will not work if you use any other ExecutorService like those created by the class Executors, because these do not support
managed blocking.

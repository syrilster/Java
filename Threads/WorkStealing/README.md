## Executor Service vs ForkJoin pool
* ExecutorService - will decide how many threads will be in the thread pool, and there is no kind of distinction between the tasks that you schedule and the subtasks that these tasks create.
* ExecutorService works better for tasks that have a mix of CPU and I/O activity
* ForkJoinPool class instead, manages threads based on 
  * Available processors.
  * Task demand.
* Typically there will be one fork-join pool for an entire application (unlike using the ExecutorService where it is typical to have more than one in any non-trivial application) and there is no need for shutdown.  

## How does work stealing happens in a ForkJoin pool
* The basic thinking here, is to use a recursive/divide and conquer approach in order to keep CPUs constantly busy. The idea is to create new tasks (forking) and suspend the current task until the new tasks complete (join) but without creating new threads and without having a shared work queue.
* Fork-join framework is implemented using work-stealing by creating a **limited number of worker threads(as many as cores)**. Each worker thread maintains a **private double-ended work queue**.
* When forking, worker pushes new task at the head of its deque. When waiting or idle, worker pops a task off the head of its deque and executes it instead of sleeping.
* If worker’s deque is empty, it steals an element off the tail of the deque of another randomly chosen worker.

## Why is work stealing only implemented in ForkJoinTask.join() and not in any other blocking methods in the Java API? 

* There are many blocking methods (Object.wait(), Future.get(), any of the concurrency primitives in java.util.concurrent, I/O methods etc), and they have nothing to do with ForkJoinPool, which is just an arbitrary class in the API, so adding special cases to all these methods would be bad design. 
* It would also lead to possibly very surprising and undesired effects. Imagine for example a user passing a task to an ExecutorService that waits on a Future, and then finding out that the task hangs very long in Future.get() just because the running thread stole some other (long-running) work item instead of waiting for the Future and continuing immediately after the result is available. Once a thread starts working on another task, it cannot return to the original task until the second task is finished. 
* Thus it is actually a good thing that other blocking methods do not do work stealing. **For a ForkJoinTask, this problem does not exist**, because it is not important that the primary task is continued as soon as possible, it is only important that all tasks together are handled as efficiently as possible.
* It is also not possible to implement your own method for doing work stealing inside a ForkJoinPool, because all the relevant parts are not public.

## Managed Blocking
* However, there is actually a second method how starvation deadlocks can be prevented. This is called managed blocking. It does not use work stealing (to avoid the problem mentioned above), but also needs the thread that is going to be block to actively cooperate with the thread pool. 
* With managed blocking, the thread tells the thread pool that it may be blocked before it calls the potentially blocking method, and also informs the pool when the blocking method is finished. The thread pool then knows that there is a risk of a starvation deadlock, and may spawn additional threads if all of its threads are currently in some blocking operation and there are still other tasks to execute. 
* Note that this is less efficient than work stealing, because of the overhead of the additional threads. If you implement a recursive parallel algorithm with ordinary futures and managed blocking instead of with ForkJoinTask and work stealing, the number of additional threads can get very large (because in the "divide" phase of the algorithm, a lot of tasks will be created and given to threads that immediately block and wait for results from sub-tasks).
* However, in the above strategy, a starvation deadlock is still prevented, and it avoids the problem that a task has to wait for a long time because its thread started working on another task in the mean time.
* The ForkJoinPool of Java also supports managed blocking. To use this, one needs to implement the interface **ForkJoinPool.ManagedBlocker** such that the potentially-blocking method that the task wants to execute is called from within the block method of this interface. Then the task may not call the blocking method directly, but instead needs to call the static method ForkJoinPool.managedBlock(ManagedBlocker). This method handles the communication with the thread pool before and after the blocking. 
It also works if the current task is not executed within a ForkJoinPool, then it just calls the blocking method.

## Managed Blocking Example in Java
* The Java 7 API that actually uses managed blocking is the **class Phaser**. (This class is a synchronization barrier like mutexes and latches, but more flexible and powerful.) 
* The Phaser allows us to build logic in which threads need to wait on the barrier before going to the next step of execution.
* We can coordinate multiple phases of execution, reusing a Phaser instance for each program phase. Each phase can have a different number of threads waiting for advancing to another phase.
* To participate in the coordination, the thread needs to register() itself with the Phaser instance.
* The thread signals that it arrived at the barrier by calling the arriveAndAwaitAdvance(), which is a blocking method. **When the number of arrived parties is equal to the number of registered parties, the execution of the program will continue, and the phase number will increase**. We can get the current phase number by calling the getPhase() method.
* When the thread finishes its job, we should call the arriveAndDeregister() method to signal that the current thread should no longer be accounted for in this particular phase.

http://www.baeldung.com/java-phaser

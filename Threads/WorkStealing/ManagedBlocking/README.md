## Managed Blocking
* There is actually a second method how starvation deadlocks can be prevented. This is called managed blocking. It does not use work stealing (to avoid the problem mentioned above), but also needs the thread that is going to be block to actively cooperate with the thread pool.
* With managed blocking, the thread tells the thread pool that it may be blocked before it calls the potentially blocking method, and also informs the pool when the blocking method is finished. The thread pool then knows that there is a risk of a starvation deadlock, and may spawn additional threads if all of its threads are currently in some blocking operation and there are still other tasks to execute.
* Note that this is less efficient than work stealing, because of the overhead of the additional threads. If you implement a recursive parallel algorithm with ordinary futures and managed blocking instead of with ForkJoinTask and work stealing, the number of additional threads can get very large (because in the "divide" phase of the algorithm, a lot of tasks will be created and given to threads that immediately block and wait for results from sub-tasks).
* However, in the above strategy, a starvation deadlock is still prevented, and it avoids the problem that a task has to wait for a long time because its thread started working on another task in the mean time.
* The ForkJoinPool of Java also supports managed blocking. To use this, one needs to implement the interface **ForkJoinPool.ManagedBlocker** such that the potentially-blocking method that the task wants to execute is called from within the block method of this interface. Then the task may not call the blocking method directly, but instead needs to call the static method ForkJoinPool.managedBlock(ManagedBlocker). This method handles the communication with the thread pool before and after the blocking.
It also works if the current task is not executed within a ForkJoinPool, then it just calls the blocking method.

## Managed Blocking Example in Java
* The Java 7 API that actually uses managed blocking is the **class Phaser**. (This class is a synchronization barrier like mutexes and latches, but more flexible and powerful.)
* The Phaser allows us to build logic in which threads need to wait on the barrier before going to the next step of execution.

## Use of Phaser
* Phaser in Java is more suitable for use where it is required to synchronize threads over one or more phases of activity.
Though Phaser can be used to synchronize a single phase, in that case it acts more like a CyclicBarrier.
But it is more suited where threads should wait for a phase to finish, then advance to next phase, wait again for that phase to finish and so on.

## How Phaser in Java works

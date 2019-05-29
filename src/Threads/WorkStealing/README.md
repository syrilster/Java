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

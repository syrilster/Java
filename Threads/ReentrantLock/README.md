## Need for having a Reentrant lock
* Every object created in Java has one mutually exclusive lock associated with it.
* When you are using synchronized it gets a lock implicitly (with no other feature) whereas when you are using any of the lock implementation (like Reentrant lock) you are using that lock explicitly.
* There are methods like lock() to acquire the lock and unlock() to release the lock.
* The ReentrantLock in Java also provides many other features like fairness, ability to interrupt a thread waiting for a lock for a specified period etc.

## Why it is called ReentrantLock
* It is called a ReentrantLock as there is an acquisition count associated with the lock which means when you use
lock() method to acquire a lock and you get it then the acquisition count is incremented to 1.
* A Reentrant lock will also allow the lock holder to enter another block of code with the same lock object as
the current thread already owns it. If a thread that holds the lock acquires it again, the acquisition count is incremented and the lock then needs to be released twice to truly release the lock.

## Convention while using ReentrantLock
* lock.lock() method is always called before the try block. When you are using reentrantlock in Java, it is a recommended practice to always immediately follow a call to lock with a try block.
* If you call lock() method with in the try block and some thing goes wrong while acquiring the lock, finally block will still be called and there you will have lock.unlock() method. So you will end up unlocking the lock which was never acquired and that will result in IllegalMonitorStateException, that’s why it is **recommended to call lock() method before try block.**
* At the same time you do want to unlock the acquired lock if something goes wrong after acquiring the lock, that is why immediately follow a call to lock with try block and finally.

## Features of ReentrantLock in Java

* ReentrantLock provides many features like fairness, ability to interrupt a thread waiting for a lock only for a specified period. 
* **Fairness** - ReentrantLock has one constructor which takes boolean value as an argument. This option lets you choose whether you want a fair or an unfair lock depending upon whether the boolean value is true or false. A **fair lock** is one where the threads acquire the lock in the same order they asked for it; whereas in case of an unfair lock a thread can sometimes acquire a lock before another thread that asked for it first.

```public ReentrantLock(boolean fair)```

* **Lock interruptibly** - ReentrantLock provides a method lockInterruptibly, where the thread acquires a lock if it is not interrupted.

```public void lockInterruptibly() throws InterruptedException```

 * **Ability to check if the lock is being held** - ReentrantLock provides ability to check if the lock is already being held using tryLock() method.

* **tryLock()** - Acquires the lock only if it is not held by another thread at the time of invocation.

* **tryLock(long timeout, TimeUnit unit)** - Acquires the lock if it is not held by another thread within the given waiting time and the current thread has not been interrupted.

Other features like -
* getHoldCount() - Queries the number of holds on this lock by the current thread.
* getWaitingThreads(Condition condition) - Returns a collection containing those threads that may be waiting on the given condition associated with this lock.
* isHeldByCurrentThread() - Queries if this lock is held by the current thread.
* isLocked() - Queries if this lock is held by any thread.

## Drawbacks of ReentrantLock in Java
* Need to wrap lock acquisitions in a try/finally block and release the lock in finally block. Otherwise, if the critical section code threw an exception, the lock might never be released.
* Need to call unlock() method explicitly. Forgetting to do that will result in lock never getting released which will create a lots of problem and make it very hard to detect performance problems. 
* With synchronization, the JVM ensures that locks are automatically released.


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


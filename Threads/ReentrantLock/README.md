## Need for having a Reentrant lock
* Every object created in Java has one mutually exclusive lock associated with it.
* When you are using synchronized it gets a lock implicitly (with no other feature) whereas when you are using any of the lock implementation (like Reentrant lock) you are using that lock explicitly.
* There are methods like lock() to acquire the lock and unlock() to release the lock.
* The ReentrantLock in Java also provides many other features like fairness, ability to interrupt a thread waiting for a lock for a specified period etc.
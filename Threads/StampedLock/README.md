## StampedLock in Java
* In Java 8 a new kind of lock StampedLock is added which apart from providing separate read and write locks also has a feature for **optimistic locking for read operations**. StampedLock in Java also provides method to upgrade read lock to write lock which is not there in ReentrantReadWriteLock in Java.
* The locking methods of StampedLock in Java **return a stamp** represented by a long value. You can use these stamps to either release a lock, to check if the lock is still valid, to convert a lock.

## Modes in StampedLock
* **Writing mode** – Write lock can be acquired using Method writeLock() which exclusively acquires the lock, blocking if necessary until available. This method returns a stamp that can be used in method unlockWrite(long)to release the lock or in conversion of the lock.
* Untimed and timed versions of **tryWriteLock** are also provided. This method won’t block and return stamp as zero if the lock is not immediately available (or with in the given in case of timed version). When the lock is held in write mode, no read locks may be obtained, and all optimistic read validations will fail.
* **Reading Mode** – Read lock can be acquired using method readLock() which non-exclusively acquires the lock, blocking if necessary until available returning a stamp that can be used to unlock or convert mode. Untimed and timed versions of tryReadLock are also provided.
* **Optimistic Reading** – This is the **new mode added in StampedLock**. The **tryOptimisticRead() method** is used to read in optimistic mode. This method returns a non-zero stamp only if the lock is **not currently held in write mode**.
Method **validate(long)** is used to validate if the values read optimistically are correct or not. Validate() method returns true if the lock has not been acquired in write mode.

## Lock conversion

StampedLock class in Java also supports methods that conditionally provide conversions across the three modes. The forms of these methods are designed to help reduce some of the code bloat that otherwise occurs in retry-based designs.

* **tryConvertToWriteLock(long stamp)** - If the lock state matches the given stamp, performs one of the following actions. 
  * If the stamp represents holding a write lock, returns it. 
  * If a read lock and if the write lock is available, releases the read lock and returns a write stamp. 
  * If an optimistic read, returns a write stamp only if immediately available. This method returns zero in all other cases.
* **tryConvertToReadLock(long stamp)** - If the lock state matches the given stamp, performs one of the following actions. 
  * If the stamp represents holding a write lock, releases it and obtains a read lock. 
  * If a read lock, returns it. 
  * If an optimistic read, acquires a read lock and returns a read stamp only if immediately available. This method returns zero in all other cases.
* **tryConvertToOptimisticRead(long stamp)** - If the lock state matches the given stamp then, 
  * If the stamp represents holding a lock, releases it and returns an observation stamp. 
  * If an optimistic read, returns it if validated. This method returns zero in all other cases, and so may be useful as a form of "tryUnlock".

## Is there any acquisition preference
The scheduling policy of StampedLock does not consistently prefer readers over writers or vice versa. All "try" methods are best-effort and do not necessarily conform to any scheduling or fairness policy.

## StampedLocks are not reentrant
Unlike ReentrantLocks, StampedLocks are not reentrant, so locked bodies should not call other unknown methods that may try to re-acquire locks (although you may pass a stamp to other methods that can use or convert it).

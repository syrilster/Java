## ReentrantReadWriteLock in Java
* In a multi-threading application multiple reads can occur simultaneously for a shared resource. 
It is only when multiple writes happen simultaneously or intermix of read and write that there is a chance of writing the 
wrong value or reading the wrong value.
* ReadWriteLock in Java makes use of the same idea in order to boost the performance by having separate pair of locks.
* A ReadWriteLock maintains a pair of associated locks -
    * One for read-only operations
    * One for writing.
* The read lock may be held simultaneously by **multiple reader threads**, so long as there are no writers. The **write lock is exclusive.**
* Note that ReadWriteLock is an interface and RentrantReadWriteLock is a class in Java which is the concrete implementation of the interface.
* Having a pair of read-write lock allows for a **greater level of concurrency** in accessing shared data than permitted by a mutual exclusion lock. It exploits the fact that while only a single thread at a time (a writer thread) can modify the shared data, in many cases any number of threads can concurrently read the data (hence reader threads).
* A read-write lock will improve performance over the use of a mutual exclusion lock if the **frequency of reads is more than writes, duration of the read operation is more than the duration of the writes**. It also depends on the contention for the data - that is, the number of threads that will try to read or write the data at the same time.
* For example, a collection that is initially populated with data and thereafter infrequently modified, while being frequently searched (such as a directory of some kind) is an ideal candidate for the use of a read-write lock. However, if updates become frequent then the data is exclusively locked most of the time and there is little, if any increase in concurrency.

## ReentrantReadWriteLock's constructor

* ReentrantReadWriteLock() - Creates a new ReentrantReadWriteLock with default (nonfair) ordering properties.
* ReentrantReadWriteLock(boolean fair) - Creates a new ReentrantReadWriteLock with the given fairness policy.

## Fair mode in ReentrantReadWriteLock
* When constructed as fair, threads contend for entry using an approximately arrival-order policy. 
* When the currently held lock is released, either the longest-waiting single writer thread will be assigned the write lock, or if there is a group of reader threads waiting longer than all waiting writer threads, that group will be assigned the read lock.

## Lock downgrading in ReentrantReadWriteLock
* ReentrantReadWriteLock also allows downgrading from the write lock to a read lock. 
* A user can first acquire a write lock, then the read lock and then release the write lock. So you are effectively left with a read lock. However, upgrading from a read lock to the write lock is not possible.

## ReentrantReadWriteLock in Java
* In a multi-threading application multiple reads can occur simultaneously for a shared resource. 
It is only when multiple writes happen simultaneously or intermix of read and write that there is a chance of writing the 
wrong value or reading the wrong value.
* ReadWriteLock in Java makes use of the same idea in order to boost the performance by having separate pair of locks.
* A ReadWriteLock maintains a pair of associated locks -
    * One for read-only operations
    * One for writing.

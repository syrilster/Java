## Exchanger in Java Concurrency

* Exchanger makes it easy for two threads to exchange data between themselves.
* Exchanger provides a synchronization point at which two threads can pair and swap elements. Exchanger waits until two separate threads call its exchange() method. When two threads have called the exchange() method, Exchanger will swap the objects presented by the threads.

## Usage of Exchanger in Java
* Exchanger can be used in a Producer-Consumer scenarios where one thread will produce the data and exchange it with the consumer thread. Consumer thread in turn will pass the empty buffer to the producer thread.

## Exchange() class methods
* **exchange() method** waits for another thread to arrive at this exchange point (unless the current thread is interrupted), and then transfers the given object to it, receiving its object in return. If another thread is already waiting at the exchange point then it is resumed for thread scheduling purposes and receives the object passed in by the current thread. The current thread returns immediately, receiving the object passed to the exchange by that other thread.
* **public V exchange(V x, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException**
In the second form of exchange() method timeout period is specified so the thread will wait for the time specified. If the specified waiting time elapses then TimeoutException is thrown. If the time is less than or equal to zero, the method will not wait at all.

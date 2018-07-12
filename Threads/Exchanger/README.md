## Exchanger in Java Concurrency

* Exchanger makes it easy for two threads to exchange data between themselves.
* Exchanger provides a synchronization point at which two threads can pair and swap elements. Exchanger waits until two separate threads call its exchange() method. When two threads have called the exchange() method, Exchanger will swap the objects presented by the threads.

## Usage of Exchanger in Java
* The Exchanger class is useful for passing data back and forth between two threads. e.g. Producer/Consumer. It has the property of naturally recycling the data structures used to pass the work and supports GC-less sharing of work in an efficient manner. 

## The Problems of Queues (BlockingQueue for Producer/Consumer)
* Queues typically use either linked-lists or arrays for the underlying storage of elements. If an in-memory queue is allowed
to be unbounded then for many classes of problem it can grow unchecked until it reaches the point of catastrophic failure
by exhausting memory. This happens when producers outpace the consumers. 
* Unbounded queues can be useful in systems where the producers are guaranteed not to outpace the consumers and memory is a precious resource, but there is always a risk if this assumption doesn’t hold and queue grows without limit. To avoid this catastrophic outcome, queues are commonly constrained in size (bounded). Keeping a queue bounded requires that it is either array-backed or that the
size is actively tracked.
* Queue implementations tend to have write contention on the head, tail, and size variables. When in use, queues are
typically always close to full or close to empty due to the differences in pace between consumers and producers. 
* They very rarely operate in a balanced middle ground where the rate of production and consumption is evenly matched. This
propensity to be always full or always empty results in high levels of contention and/or expensive cache coherence. The
**problem is that even when the head and tail mechanisms are separated using different concurrent objects such as locks or
CAS variables, they generally occupy the same cache-line**.
* In Java there is a further problem with the use of queues, as **they are significant sources of garbage**. Firstly, objects have
to be allocated and placed in the queue. Secondly, if linked-list backed, objects have to be allocated representing the
nodes of the list. When no longer referenced, all these objects allocated to support the queue implementation need to be
re-claimed.

## Exchange() class methods
* **exchange() method** waits for another thread to arrive at this exchange point (unless the current thread is interrupted), and then transfers the given object to it, receiving its object in return. If another thread is already waiting at the exchange point then it is resumed for thread scheduling purposes and receives the object passed in by the current thread. The current thread returns immediately, receiving the object passed to the exchange by that other thread.
* **public V exchange(V x, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException**
In the second form of exchange() method timeout period is specified so the thread will wait for the time specified. If the specified waiting time elapses then TimeoutException is thrown. If the time is less than or equal to zero, the method will not wait at all.

## High performance Inter-Thread message library
* Refer the LMAX Disruptor which claims to be the fastest trading platform in the world. https://lmax-exchange.github.io/disruptor/

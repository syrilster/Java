## CountDownLatch in Java Concurrency
* There are scenarios in an application when you want one or more threads to wait until one or more events being performed in other threads complete. CountDownLatch provided in the Java concurrent API helps in handling such scenarios.

## How CountDownLatch is used
* CountDownLatch in Java, as the name suggests, can be visualized as a latch that is released only after the given number of events occur. 
* CountDownLatch is initialized with a count (given number of events).
* Each time one of the events occur, the count is decremented using the countdown() method.
* Thread(s) that are waiting for the latch to release (current count reaches zero due to invocations of the countDown()method) are blocked using await() method.

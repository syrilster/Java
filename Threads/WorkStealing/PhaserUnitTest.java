package Threads.WorkStealing;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Let’s say that we want to coordinate multiple phases of actions.
 * Three threads will process the first phase, and two threads will process the second phase.
 */
public class PhaserUnitTest {
    @Test
    public void basicTest() {
        //Given
        ExecutorService executorService = Executors.newCachedThreadPool();
        Phaser phaser = new Phaser(1);
        assertEquals(0, phaser.getPhase());

        //When
        executorService.submit(new ManagedBlockingUsingPhaser("thread-1", phaser));
        executorService.submit(new ManagedBlockingUsingPhaser("thread-2", phaser));
        executorService.submit(new ManagedBlockingUsingPhaser("thread-3", phaser));

        //Then
        phaser.arriveAndAwaitAdvance();
        assertEquals(1, phaser.getPhase());

        //And
        executorService.submit(new ManagedBlockingUsingPhaser("thread-4", phaser));
        executorService.submit(new ManagedBlockingUsingPhaser("thread-5", phaser));
        phaser.arriveAndAwaitAdvance();
        assertEquals(2, phaser.getPhase());

        phaser.arriveAndDeregister();
    }
}

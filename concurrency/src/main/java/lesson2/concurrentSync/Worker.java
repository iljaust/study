package lesson2.concurrentSync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
    private final Logger log = LogManager.getLogger(Worker.class);

    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch) {
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();
            log.info(Thread.currentThread().getName() + " finished");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

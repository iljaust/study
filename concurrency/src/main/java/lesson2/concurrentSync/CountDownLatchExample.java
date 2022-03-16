package lesson2.concurrentSync;

import lesson2.bakeryNew.BakerNumberTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final Logger log = LogManager.getLogger(CountDownLatchExample.class);

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(4);

        Thread threadOne = new Thread(new Worker(1000, latch));
        Thread threadTwo = new Thread(new Worker(2000, latch));
        Thread threadThree = new Thread(new Worker(3000, latch));
        Thread threadFour = new Thread(new Worker(4000, latch));

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(Thread.currentThread().getName() + " has finished");
    }
}

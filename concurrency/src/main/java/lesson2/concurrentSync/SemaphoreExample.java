package lesson2.concurrentSync;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private Semaphore semaphore;
    private int count;

    public SemaphoreExample() {
        semaphore = new Semaphore(1);
        count = 0;
    }

    void increase() throws InterruptedException {
        semaphore.acquire();
        this.count = this.count + 1;
        Thread.sleep(1000);
        semaphore.release();

    }

    int getCount() {
        return this.count;
    }
}

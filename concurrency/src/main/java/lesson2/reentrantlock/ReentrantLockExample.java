package lesson2.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final Lock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void incrementWithTryLock(){
        if(lock.tryLock()) {
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }
    }
}

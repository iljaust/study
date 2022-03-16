package lesson2.reentrantlock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithCondition {
    List<String> list = new LinkedList<>();
    int CAPACITY = 5;

    Lock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();

    public void add(String item){
        try {
            lock.lock();
            while(list.size() == CAPACITY) {
                try {
                    stackFullCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(item);
            stackEmptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String take() {
        try {
            lock.lock();
            while(list.size() == 0) {
                try {
                    stackEmptyCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return list.remove(0);
        } finally {
            stackFullCondition.signalAll();
            lock.unlock();
        }
    }
}

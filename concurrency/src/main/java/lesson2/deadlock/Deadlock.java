package lesson2.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Deadlock {
    private final static Logger log = LogManager.getLogger(Deadlock.class);

    public static void main(String[] args) throws InterruptedException {
        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new Thread(() ->{
            synchronized (object1) {
                log.info("Inside first block");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    log.info("Inside second block");
                }
            }
        });

        Thread thread2 = new Thread(() ->{
            synchronized (object2) {
                log.info("Inside first block");
                synchronized (object1) {
                    log.info("Inside second block");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }

}

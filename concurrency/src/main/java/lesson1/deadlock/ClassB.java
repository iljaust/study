package lesson1.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassB {

    private final Logger log = LogManager.getLogger(ClassB.class);

    public synchronized void methodB(ClassA classA) {

        log.info("Inside ClassB methodB " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);

            log.info("Waiting to get to classA " + Thread.currentThread().getName());

            classA.methodA(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package lesson1.deadlock;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassA {

    private final Logger log = LogManager.getLogger(ClassA.class);

    public synchronized void methodA(ClassB classB){
        log.info("Inside ClassA methodA " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);

            log.info("Waiting to get to classB " + Thread.currentThread().getName());

            classB.methodB(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

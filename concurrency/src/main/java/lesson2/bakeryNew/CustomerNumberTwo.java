package lesson2.bakeryNew;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerNumberTwo {
    private final Logger log = LogManager.getLogger(CustomerNumberTwo.class);
    private final List<String> breadShelf;

    public CustomerNumberTwo(List<String> breadShelf){
        this.breadShelf = breadShelf;
    }

    public void eat(){
        while(!Thread.currentThread().isInterrupted()){
            synchronized (breadShelf) {
                while (breadShelf.isEmpty()) {
                    try {
                        log.info("Customer: I want some bread, please !");
                        breadShelf.wait();
                    } catch (InterruptedException e) {
                        log.info("Customer: I'll go home soon !");
                        Thread.currentThread().interrupt();
                        break;
                    }
                }

                if (!breadShelf.isEmpty()) {
                    breadShelf.remove(0);
                    log.info("Customer: Bread is so tasty, thank you !");
                }
                if (breadShelf.isEmpty()) {
                    log.info("Customer: Oh no, shelf is empty again!");
                    breadShelf.notifyAll();
                }
            }
        }
    }
}

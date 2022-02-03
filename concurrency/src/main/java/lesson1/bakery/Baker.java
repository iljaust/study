package lesson1.bakery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Baker {
    private final Logger log = LogManager.getLogger(Baker.class);
    private Boolean isCustomerHungry;

    public Baker(Boolean isCustomerHungry){
        this.isCustomerHungry = isCustomerHungry;
    }

    public synchronized void startWorkingShift(List<String> breadShelf){
        log.info("Baker is happy to start new day!");
        int waiting = 0;

        while(isCustomerHungry){

            if(breadShelf.isEmpty()){
                try {
                    log.info("Baker is cooking fresh bread for Customer");
                    Thread.sleep(5000);

                    synchronized (breadShelf){
                        breadShelf.add("Fresh bread");
                    }
                    waiting = 0;
                    log.info("Baker : - Bread on the shelf, enjoy !");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    if(waiting == 5){
                        isCustomerHungry = false;
                    }else {
                    waiting++;
                    log.info("Baker : - No hungry customers I can relax ");
                    Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("Day is over. See you tomorrow!");
    }

}

package lesson1.bakery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Customer {
    private final Logger log = LogManager.getLogger(Baker.class);
    private boolean feelHungry;

    public Customer(boolean feelHungry) {
        this.feelHungry = feelHungry;
    }

    public void getSomeFood(List<String> breadShelf,Integer amountToEat){
        Integer breadToEat = amountToEat;
        while(feelHungry){
            if(breadShelf.isEmpty()){
                try {
                log.info("Customer : - I'm starving! I want some bread!");
                Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                synchronized (breadShelf){
            breadShelf.remove(0);
                }

                log.info("Customer : - The bread is so tasty");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                breadToEat--;
                if(breadToEat == 0){
                    log.info("Customer : - I'm done! Thank you!");
                    return;
                }
            }
        }
    }
}

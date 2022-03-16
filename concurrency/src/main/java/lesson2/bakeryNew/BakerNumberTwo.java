package lesson2.bakeryNew;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BakerNumberTwo {
    private final Logger log = LogManager.getLogger(BakerNumberTwo.class);
    private final List<String> breadShelf;

    public BakerNumberTwo(List<String> breadShelf){
        this.breadShelf = breadShelf;
    }

    public void work(){
        synchronized (breadShelf) {
            while (!Thread.currentThread().isInterrupted()) {
                while (!breadShelf.isEmpty()) {
                    try {
                        log.info("Baker : Work done, now can relax");
                        breadShelf.wait();
                    } catch (InterruptedException e) {
                        log.info("Baker : I'll be closing the shop soon");
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
                synchronized (breadShelf) {
                    log.info("Baker : Give me a sec I'll make a fresh loaf of bread!");
                    breadShelf.add("Bread");
                    log.info("Baker : Time to eat, guys!");
                    breadShelf.notifyAll();
                }
            }
        }
    }

}

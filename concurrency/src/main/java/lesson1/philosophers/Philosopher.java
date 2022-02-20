package lesson1.philosophers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Philosopher implements Runnable{

    private final Logger log = LogManager.getLogger(Philosopher.class);
    private final Quotes quote;
    private final Chopstick chopstick1;
    private final Chopstick chopstick2;
    private final String name;

    public Philosopher(String name, Chopstick chopstick1,Chopstick chopstick2, Quotes quote) {
        this.name = name;
        this.chopstick1 = chopstick1;
        this.chopstick2 = chopstick2;
        this.quote = quote;
    }

    @Override
    public void run() {
        try {
        while(true){
            synchronized (chopstick1){
                synchronized (chopstick2){
                    log.info("{} is currently eating", name);
                    Thread.sleep(1000);
                }
            }
            log.info("{} : {}", name, quote.getQuote());
            Thread.sleep(3000);
        }
        } catch (InterruptedException e) {
            log.info("{} : Time to go, bye", name);
            return;
        }

    }
}

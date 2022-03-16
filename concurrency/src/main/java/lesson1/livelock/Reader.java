package lesson1.livelock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reader {
    private final Logger log = LogManager.getLogger(Reader.class);
    private final String name;
    private Boolean reading;

    public Reader(String name,Boolean reading){
        this.name = name;
        this.reading = reading;
    }

    public Boolean isReading(){
        return reading;
    }

    public synchronized void read(Book book, Reader otherReader){

        while(reading){

            if (book.getReader() != this) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    log.info("{} : I'm tired of reading going home ", name);
                    reading = false;
                    e.printStackTrace();
                }
                continue;
            }

            if(otherReader.isReading()){
                log.info("{} gives time to other reader ", name);
                book.setReader(otherReader);
                continue;
            }

            log.info("{} finished reading", name);
            reading = false;
            book.setReader(otherReader);
        }
    }
}

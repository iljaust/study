package lesson1.readwritelock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReadWriteFromFile {

    private final Logger log = LogManager.getLogger(ReadWriteFromFile.class);
    private final MyReadWriteLock lock  = new MyReadWriteLock();

    public void readFromFile(Path filepath) {
        try {
            lock.lockRead();
            log.info("ReadLock acquired. Started reading from file :  {}", filepath.getFileName());
            String content = Files.readString(filepath, StandardCharsets.US_ASCII);
            Thread.sleep(3000);
            log.info("File :  {}   Content : {}", filepath.getFileName(),content);
        }
        catch (InterruptedException | IOException e){
            log.error("Read thread been interrupted " + e);
        }
        finally {
            lock.unlockRead();
            log.info("ReadLock released for file :  {}", filepath.getFileName());
        }
    }

    public void writeToFile(Path filepath, String text) throws InterruptedException {
        try {
            lock.lockWrite();
            log.info("WriteLock acquired. Started writing to file :  {}", filepath.getFileName());
            Files.writeString(filepath , "Line added successfully", StandardOpenOption.APPEND);
        }
        catch (InterruptedException | IOException e){
            log.error("Write thread been interrupted " + e);
        }
        finally {
            lock.unlockWrite();
            log.info("WriteLock released for file :  {}", filepath.getFileName());
        }
    }


}

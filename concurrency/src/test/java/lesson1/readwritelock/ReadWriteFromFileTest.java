package lesson1.readwritelock;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteFromFileTest {

    private final String filepath  = "src/test/resources/lesson1/readwritelock/text.txt";
    private final String resultFilepath  = "src/test/resources/lesson1/readwritelock/textResult.txt";
    private final ReadWriteFromFile readWriteFromFile = new ReadWriteFromFile();

    @BeforeEach
    void setUp() throws IOException {
        Files.writeString(Path.of(filepath), "Welcome to Lesson 1 file !!!");
    }

    @Test
    public void readerReadsThenWriterWritesToFileWhileNewReaderGetsBlockedAndThenReadNewFile() throws IOException {
        new Thread(() -> readWriteFromFile.readFromFile(Path.of(filepath))).start();
        new Thread(() -> readWriteFromFile.readFromFile(Path.of(filepath))).start();
        new Thread(() -> {
            try {
                readWriteFromFile.writeToFile(Path.of(filepath)," Addition text");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> readWriteFromFile.readFromFile(Path.of(filepath))).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        assertTrue(FileUtils.contentEquals(new File(filepath), new File(resultFilepath)));

    }
}
package lesson1.bakery;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BakerTest {

    private List<String> breadShelf;
    private final Baker baker = new Baker(true);

    @BeforeEach
    void setUp() {
        breadShelf = new LinkedList<>();
    }

    @Test
    public void givenEmptyShelf_whenBakerStartsWork_thenShelfNotEmpty(){

        baker.startWorkingShift(breadShelf);

        assert breadShelf.size() == 1;
    }
}
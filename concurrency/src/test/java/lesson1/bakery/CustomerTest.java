package lesson1.bakery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


class CustomerTest {
    private List<String> breadShelf;
    private final Customer customer = new Customer(true);

    @BeforeEach
    void setUp() {
        breadShelf = new LinkedList<>();
    }

    @Test
    public void givenFullShelf_whenCustomerStartsEat_thenShelfEmpty(){
        breadShelf.add(new String("Bread"));
        breadShelf.add(new String("Bread"));
        customer.getSomeFood(breadShelf,2);

        assert breadShelf.size() == 0;
    }

}
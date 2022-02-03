package lesson1.bakery;

import java.util.LinkedList;
import java.util.List;

public class Bakery {
    final static List<String> breadShelf = new LinkedList<>();;
    public static void main(String[] args) {

        Baker baker = new Baker(true);
        Customer customer = new Customer(true);

        new Thread(() -> baker.startWorkingShift(breadShelf)).start();
        new Thread(() -> customer.getSomeFood(breadShelf,99)).start();
    }
}

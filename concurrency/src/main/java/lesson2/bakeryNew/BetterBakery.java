package lesson2.bakeryNew;

import java.util.LinkedList;
import java.util.List;

public class BetterBakery {

    static volatile List<String> breadShelf = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {

        BakerNumberTwo baker = new BakerNumberTwo(breadShelf);
        CustomerNumberTwo customer = new CustomerNumberTwo(breadShelf);

        Thread thread1 = new Thread(baker::work);
        Thread thread2 = new Thread(customer::eat);

        thread1.start();
        thread2.start();

        Thread.sleep(100000);

        thread2.interrupt();
        thread1.interrupt();

    }
}

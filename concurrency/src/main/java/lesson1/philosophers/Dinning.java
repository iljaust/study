package lesson1.philosophers;

public class Dinning {
    public static void main(String[] args) throws InterruptedException {
        Quotes quotes = new Quotes();
        Chopstick chopstick1 = new Chopstick();
        Chopstick chopstick2 = new Chopstick();
        Chopstick chopstick3 = new Chopstick();
        Chopstick chopstick4 = new Chopstick();
        Chopstick chopstick5 = new Chopstick();

        Thread thread1 = new Thread(new Philosopher("Socrates",chopstick1,chopstick2,quotes));
        Thread thread2 =new Thread(new Philosopher("Immanuel Kant",chopstick3,chopstick2,quotes));
        Thread thread3 =new Thread(new Philosopher("Voltaire",chopstick3,chopstick4,quotes));
        Thread thread4 =new Thread(new Philosopher("Thomas Hobbes",chopstick4,chopstick5,quotes));
        Thread thread5 =new Thread(new Philosopher("Martin Heidegger",chopstick1,chopstick5,quotes));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


        Thread.sleep(100000);

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        thread4.interrupt();
        thread5.interrupt();

    }
}

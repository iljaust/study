package lesson1.livelock;

public class Library {
    public static void main(String[] args) {
        final Reader reader1 = new Reader("John",true);
        final Reader reader2 = new Reader("Max",true);

        final Book book = new Book(reader1);

        new Thread(() -> reader1.read(book,reader2)).start();
        new Thread(() -> reader2.read(book,reader1)).start();
    }
}

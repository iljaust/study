package lesson2.jmm;

public class BookStore {
    private long storedBookCount = 0;
    private long bookTakenCount  = 0;

    private volatile boolean hasNewBook = false;

    private String book = null;

    // called by Book producing thread
    public void storeBook(String book) {
        this.book = book;
        this.storedBookCount++;
        this.hasNewBook = true; //A write to a non-volatile or volatile variable that happens before a write to a volatile variable is guaranteed to happen before the write to that volatile variable.
    }

    // called by Book get thread
    public String takeBook() {
        while( !hasNewBook) { //A read of a volatile variable will happen before any subsequent reads of volatile and non-volatile variables.
            //Because of the volatile read visibility guarantee, when !hasNewBook is read from main memory, so are all other variables visible to the thread at that time.
        }

        String newBook = this.book;
        this.bookTakenCount++;
        this.hasNewBook = false;
        return newBook;
    }
}

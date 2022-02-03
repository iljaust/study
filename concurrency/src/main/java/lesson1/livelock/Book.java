package lesson1.livelock;

public class Book {
    private Reader reader;

    public Book(Reader reader){
        this.reader = reader;
    }

    public Reader getReader(){
        return reader;
    }

    public synchronized void setReader(Reader newReader){
        reader = newReader;
    }
}

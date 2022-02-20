package lesson1.philosophers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Quotes {

    private List<String> quotes = new ArrayList<>();

    public Quotes() {
        addQuotes();
    }

    private void addQuotes(){
        quotes.add("The unexamined life is not worth living");
        quotes.add("Whereof one cannot speak, thereof one must be silent");
        quotes.add("Entities should not be multiplied unnecessarily");
        quotes.add("I think therefore I am");
        quotes.add("One cannot step twice in the same river");
    }

    public String getQuote(){
        return quotes.get(ThreadLocalRandom.current().nextInt(quotes.size()));
    }
}

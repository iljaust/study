package lesson2.jmm;

public class ValueExchanger {
    private int valA;
    private int valB;
    private int valC;

    public void set(int a, int b, int c) {
        this.valA = a;
        this.valB = b;

        synchronized(this) {
            this.valC = c;
        }
        //The end of a synchronized block provides the visibility guarantee that all changed variables will be written back to main memory when the thread exits the synchronized block.
    }

    public void get() {
        //When the thread calling get() enters the synchronized block, all variables are re-read in from main memory.
        //That is why this synchronized block is placed at the beginning of the method - to guarantee that all variables are refreshed from main memory before they are read
        //None of the reads of the variables can be reordered to appear before the beginning of the synchronized block
        synchronized(this) {
            int c = valC;
        }
        int b = valB;
        int a = valA;

    }
}

package lesson2.volatileLock;


public class VolatileLock {

    private volatile Boolean lock = false;

    public synchronized void lock(){
        while(lock){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        lock = true;
    }
    public synchronized void unlock(){
        lock = false;
        notifyAll();
    }
}

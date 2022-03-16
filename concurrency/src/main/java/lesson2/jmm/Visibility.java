package lesson2.jmm;

//JMM doesn't guarantee that changes of boolean stop will be visible for other threads
public class Visibility {
    private static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread( () ->{
                int i = 0;
                while (!stop){
                    System.out.println(i++);
                }
            }
        );
        thread.start();
        Thread.sleep(2000);
        stop = true;

        thread.join();
    }
}


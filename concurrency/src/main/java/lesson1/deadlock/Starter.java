package lesson1.deadlock;

public class Starter {
    public static void main(String[] args) {

        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        new Thread(() -> classB.methodB(classA)).start();
        new Thread(() -> classA.methodA(classB)).start();

    }
}

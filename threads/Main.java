public class Main {
    public static void main(String[] args) {
        OddEven oe = new OddEven();
        Thread t1 = new Thread(() -> oe.printOdd());
        Thread t2 = new Thread(() -> oe.printEven());
        t1.start();
        t2.start();
    }
}
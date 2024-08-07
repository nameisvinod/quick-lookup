public class ThreadLocalExample {
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();
    }

    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " initial value  :: " + threadLocal.get());
            threadLocal.set(threadLocal.get() + 1);
            System.out.println(Thread.currentThread().getName() + " final value  :: " + threadLocal.get());

        }
    }
}

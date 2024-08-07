import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int count = 5;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " starting");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    System.out.println(Thread.currentThread().getName() + " finished");
                    latch.countDown();
                }
            }).start();
        }

        latch.await();
        System.out.println("All threads completed.");
    }
}

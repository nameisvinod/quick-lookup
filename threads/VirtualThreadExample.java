import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.ofVirtual().name("virtual thread").start(()->{
            int id = ThreadLocalRandom.current().nextInt(100);
            System.out.println("This is virtual thread " + id);
        });

        new Thread(()->{
            int id = ThreadLocalRandom.current().nextInt(100);
            System.out.println("Normal thread " + id);
        }).start();
        try{
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executor.submit(() -> {
                System.out.println("Hello from virtual thread : " + finalI);
            });
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, NANOSECONDS);
    }
}

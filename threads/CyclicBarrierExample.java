import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int parties = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, () ->{
            System.out.println("All parties have arrived");
        });

        for (int i = 0; i < parties; i++) {
            new Thread(()->{
               try{
                   System.out.println(Thread.currentThread().getName() + " waiting at barrier");
                   cyclicBarrier.await();
                   System.out.println(Thread.currentThread().getName() + " crossed barrier");
               } catch (BrokenBarrierException e) {
                   throw new RuntimeException(e);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
            }).start();
        }
    }
}

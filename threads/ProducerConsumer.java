//Implement a producer-consumer problem using blocking queues.


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
    private final BlockingQueue<Integer> queue;
    public ProducerConsumer(int capacity){
        queue = new LinkedBlockingQueue<>(capacity);
    }

    public void produce() throws InterruptedException {
        while(true){
            int item = new Random().nextInt();
            queue.put(item);
        }
    }

    public void consume() throws InterruptedException {
        while(true){
            int item = queue.take();
            System.out.println("Item " + item);
        }
    }
}

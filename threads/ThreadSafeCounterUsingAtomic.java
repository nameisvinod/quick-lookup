import java.util.concurrent.atomic.AtomicInteger;
//Implement a thread-safe counter using AtomicInteger.

public class ThreadSafeCounterUsingAtomic {
    private AtomicInteger atomicInteger = new AtomicInteger(1);
    public void increment(){
        atomicInteger.getAndIncrement();
    }
    public int get(){
        return atomicInteger.get();
    }
}

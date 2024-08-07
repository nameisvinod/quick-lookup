public class SharedResource {
    private int count = 0;

    public synchronized int get(){
        return count;
    }

    public synchronized void increment(){
        count++;
    }
}

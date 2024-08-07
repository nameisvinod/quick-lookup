public class OddEven {
    private int count = 1;
    private boolean isOdd = true;
    private int limit = 10;
    public synchronized void printOdd(){
        while(count<=10){
            while(!isOdd){
                try{
                    wait();
                }catch (InterruptedException ex){

                }
            }
            System.out.println("value  :: " + count);
            isOdd = false;
            count++;
            notify();
        }
    }

    public synchronized void printEven(){
        while(count<=10){
            while(isOdd){
                try{
                    wait();
                }catch (InterruptedException ex){

                }
            }
            System.out.println("value  :: " + count);
            isOdd = false;
            count++;
            notify();
        }
    }
}

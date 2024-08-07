import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            int finalI = i;
            futures.add(executorService.submit(()->
                factorial(finalI)));
        }

        for(Future f : futures){
            System.out.println(f.get());
        }
        executorService.shutdown();
    }
    private static int factorial(int n){
        if (n < 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

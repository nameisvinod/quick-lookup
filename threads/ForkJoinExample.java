import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
    public static void main(String[] args) {
        int limit = 5;
        long[] nums = new long[limit];
        for (int i = 0; i < limit; i++) {
            nums[i] = i+1;
        }

        SumTask sumTask = new SumTask(nums, 0, limit);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long sum = forkJoinPool.invoke(sumTask);
        System.out.println("Sum :: " + sum);
    }

    public static class SumTask extends RecursiveTask<Long>{
        private static final int THRESHOLD = 1000;
        private long[] nums;
        private int start;
        private int end;

        public SumTask(long[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if(end-start <= THRESHOLD){
                long res = 0l;
                for (int i = start; i < end; i++) {
                    res+=nums[i];
                }
                return res;
            }
            int mid = (start+end)/2;
            SumTask leftTask = new SumTask(nums, start, mid);
            SumTask rightSumTask = new SumTask(nums, mid, end);
            leftTask.fork();
            long rightResult = rightSumTask.compute();
            long leftResult = leftTask.join();
            return leftResult+rightResult;
        }
    }
}

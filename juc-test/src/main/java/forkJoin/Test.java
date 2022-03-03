package forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author jesse.hu
 * @date 2022/3/3 10:53
 */
public class Test extends RecursiveTask<Integer> {

    public Test(int begin, int end, int res) {
        this.begin = begin;
        this.end = end;
        this.res = res;
    }

    private static final Integer VALUE = 10;
    private int begin;
    private int end;
    private int res;

    public Test(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test test = new Test(0, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(test);

        Integer result = forkJoinTask.get();
        System.out.println(result);

        forkJoinPool.shutdown();
    }

    @Override
    protected Integer compute() {
        if (end - begin<=VALUE){
            // 相加
            for (int i = begin; i <=end ; i++) {
                res +=i;
            }
        }else {
            // 分
            int middle = begin + (end-begin)/2;
            Test left = new Test(begin,middle);
            Test right = new Test(middle,end);
            left.fork();
            right.fork();
            res = left.join() + right.join();
        }
        return res;
    }
}

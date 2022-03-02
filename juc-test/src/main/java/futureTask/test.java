package futureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author jesse.hu
 * @date 2022/3/2 16:05
 */
public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> 1024);
        new Thread(futureTask).start();
        while (!futureTask.isDone()) {
            System.out.println("wait");
        }

        System.out.println(futureTask.get());
        System.out.println(futureTask.get()); // 这时再获取futureTask的结果，不会再去计算，而是直接使用上一次计算的结果

        System.out.println(Thread.currentThread().getName());
    }
}

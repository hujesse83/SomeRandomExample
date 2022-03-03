package completeTable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author jesse.hu
 * @date 2022/3/3 11:13
 * 要拿结果输出的时候，还是阻塞的，不拿结果时异步
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 异步调用、没有返回值
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"runAsync");
        });
        completableFuture.get();

        // 异步调用有返回值
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync");
            return 7;
        });
        completableFuture1.whenComplete((t,u)->{
            System.out.println("-----t"+t);  // 返回结果
            System.out.println("-----u"+u);  // 异常处理
        }).get();

    }
}

package threadPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author jesse.hu
 * @date 2022/2/11 09:45
 */
public class CallableDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;


    public static void main(String[] args) {
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        ArrayList<Future<String>> futureList = new ArrayList<>();
        MyCallable myCallable = new MyCallable();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executor.submit(myCallable);
            // 将返回值future 添加到list、我们可以通过future获得执行 Callable得到到返回值
            futureList.add(future);
        }
        for (Future<String> fut : futureList) {
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}

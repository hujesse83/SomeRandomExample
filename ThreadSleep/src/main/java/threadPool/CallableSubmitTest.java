package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author jesse.hu
 * @date 2022/2/11 09:32
 * submit()方法用于提交需要返回值的任务
 */
public class CallableSubmitTest {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> submit = executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        String s = submit.get(3, TimeUnit.SECONDS);  // 在规定时间内无返回会抛出异常
        System.out.println(s);
        executorService.shutdown();
        /**
         * shutdown() VS  shutdownNow() : 前者关闭线程池, 但是队列里的任务得执行完毕, 后者关闭线程池, 终止正在运行的任务.
         * isTerminated() VS isShutdown() : 前者返回true, 后者必须所有提交的任务完成后返回true.
         */
    }
}

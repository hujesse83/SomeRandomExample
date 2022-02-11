package threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author jesse.hu
 * @date 2022/2/11 09:44
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2L);
        return Thread.currentThread().getName();
    }
}

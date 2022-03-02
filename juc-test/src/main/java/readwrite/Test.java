package readwrite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jesse.hu
 * @date 2022/3/2 17:16
 */
public class Test {
    public static void main(String[] args) {


        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.put(finalI + "", finalI);
            }, i + "").start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.get(finalI + "");
            }, i + "").start();
        }
    }
}


class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        // 写时加锁
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写操作" + key);
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "放置完毕" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 写完释放锁
            rwLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        rwLock.readLock().lock();
        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName() + "正在取操作" + key);
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "取完毕" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }

        return result;
    }
}
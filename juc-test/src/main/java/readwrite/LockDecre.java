package readwrite;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jesse.hu
 * @date 2022/3/3 09:28
 */
public class LockDecre {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();


        /**
         * 锁降级
         */
        // 1、获取写锁
        writeLock.lock();
        System.out.println("atguigu");
        // 2、获取读锁
        readLock.lock();
        System.out.println("--read");

        //3、释放写锁
        writeLock.unlock();
        //4、释放读锁
        readLock.unlock();


        /**
         * 在这个情况下, 获得了读锁就不能获取写锁
         */
        // 获取读锁
        readLock.lock();
        System.out.println("--read");

        // 1、获取写锁
        writeLock.lock();
        System.out.println("atguigu");

    }
}

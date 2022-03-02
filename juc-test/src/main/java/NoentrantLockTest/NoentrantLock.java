package NoentrantLockTest;

import java.util.concurrent.locks.Lock;

/**
 * @author jesse.hu
 * @date 2022/3/2 10:29
 */
public class NoentrantLock {
    // 不可重入锁
    private boolean isLocked = false;

    public synchronized void lock() throws Exception{
        while (isLocked){
           wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.print();

    }
    // 可重入：一个线程可以进入任何一个 该线程已经拥有的锁所同步着的代码块
    // 不可重入锁也叫 自旋锁
    // 该test case 表明L：一个线程拿到了资源的锁，没释放锁又来拿请求该资源。
    static class Test{
        NoentrantLock noentrantLock = new NoentrantLock();
        public void print() throws Exception {
            noentrantLock.lock();
            say();
            noentrantLock.unlock();
        }
        public void say() throws Exception {
            noentrantLock.lock();
            System.out.println("hello");
            noentrantLock.unlock();
        }
    }
}

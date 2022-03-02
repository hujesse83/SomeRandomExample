package NoentrantLockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jesse.hu
 * @date 2022/3/2 10:43
 */
public class ReentantLockTest {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;
    public synchronized void lock() throws Exception{
        Thread thread = Thread.currentThread();
        while (isLocked && lockedBy!=thread){
            wait();  // wait()的作用是让当前线程进入等待状态  并释放锁
        }
        isLocked = true;
        lockedCount ++;
        lockedBy = thread;
    }

    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if (lockedCount==0){ //获得该锁的那个线程，获得了多少次该锁（即调用了几次lock方法，即重入了几次），就得unlock几次，即lockedCount=0，才会把那些wait（阻塞）的线程唤醒
                isLocked = false;
                notify();
            }
        }
    }



    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.print();

    }

    //可重入就意味着：一个线程可以进入任何一个 该线程 已经拥有的锁所同步着的代码块
    static class Test{
        ReentrantLock lock = new ReentrantLock();
        public void print() throws Exception {
            lock.lock();
            say();
            lock.unlock();
        }
        public void say() throws Exception {
            lock.lock();
            System.out.println("hello");
            lock.unlock();
        }
    }
}

package communicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jesse.hu
 * @date 2022/3/2 13:57
 *
 *
 * 使用reentrantLock实现线程间通信
 */
public class Demo2 {
    private int number = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public  void incr() throws InterruptedException {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"唤醒");
            while (number!=0){   // 应该改为while
                System.out.println(Thread.currentThread().getName() + "阻塞等待");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"::"+ ++number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public  void decr() throws InterruptedException {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"唤醒");
            while (number!=1){   // 应该改为while
                System.out.println(Thread.currentThread().getName() + "阻塞等待");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"::"+ --number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo2 demo1 = new Demo2();

        new Thread(()->{
            for (int j = 0; j < 10; j++) {
                try {
                    demo1.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(()->{
            for (int j = 0; j < 10; j++) {
                try {
                    demo1.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(()->{
            for (int j = 0; j < 10; j++) {
                try {
                    demo1.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(()->{
            for (int j = 0; j < 10; j++) {
                try {
                    demo1.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}


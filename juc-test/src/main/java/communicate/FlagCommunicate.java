package communicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jesse.hu
 * @date 2022/3/2 14:17
 */
public class FlagCommunicate {





}


class Share{
    private int flag = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition a1Condition = lock.newCondition();
    private final Condition b2Condition = lock.newCondition();
    private final Condition c3Condition = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try{
            while (flag!=1){
                a1Condition.await();
            }
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName() + "::"+i+"print 5");
            }
            flag = 2;
            b2Condition.signal();
        }finally {
            lock.unlock();
        }
    }
    public void print10() throws InterruptedException {
        lock.lock();
        try{
            while (flag!=2){
                b2Condition.await();
            }
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "::"+i+"print 10");
            }
            flag = 3;
            c3Condition.signal();
        }finally {
            lock.unlock();
        }
    }
    public void print15() throws InterruptedException {
        lock.lock();
        try{
            while (flag!=3){
                c3Condition.await();
            }
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread().getName() + "::"+i+"print 15");
            }
            flag = 1;
            a1Condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try{
                    share.print5();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try{
                    share.print10();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try{
                    share.print15();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"CC").start();
    }
}


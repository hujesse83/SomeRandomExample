package utils;

import java.util.concurrent.CountDownLatch;

/**
 * @author jesse.hu
 * @date 2022/3/2 16:14
 *
 * 演示情况：6个同学离开教室，离开之后锁门。
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        // 6个同学陆续离开教室, 但是有同学被关到门里面了
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"同学离开了教室");
            },i+"").start();
        }
        System.out.println("班长锁门了");

        /**
         * 使用CountDownLatch
         */
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"同学离开了教室");
                countDownLatch.countDown();
            },i+"").start();
        }

        countDownLatch.await();// 只有当contDown当值为0, 才会唤醒该线程
        System.out.println("班长锁门了");
    }
}

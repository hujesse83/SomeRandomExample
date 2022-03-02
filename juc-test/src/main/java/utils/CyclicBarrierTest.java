package utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jesse.hu
 * @date 2022/3/2 16:26
 */
public class CyclicBarrierTest {
    private static final int NUMBER = 6;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,()->{
            System.out.println("召唤黑暗大魔法师");
        });

        for (int i = 0; i < NUMBER; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();    // 遇到6个阻塞的线程就执行上面的runnable方法
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}

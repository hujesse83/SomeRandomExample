package utils;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author jesse.hu
 * @date 2022/3/2 16:34
 *
 * 场景： 6凉汽车 停三个停车位
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);


        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();   // 抢占车位
                    System.out.println(Thread.currentThread().getName()+ "抢占到了车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));   // 设置停车的时间 5s
                    System.out.println(Thread.currentThread().getName()+ "------------离开到了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();   // 释放
                }
            }).start();
        }
    }
}

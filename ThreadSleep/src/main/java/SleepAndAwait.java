import java.util.concurrent.TimeUnit;

/**
 * Thread.sleep是不会释放锁，而wait是释放锁的(对象锁)
 * Testcase 1、
 */

public class SleepAndAwait implements Runnable {

    private int number = 10;

    private  synchronized void firstMethod() {
        System.out.println("Method A");
        number += 100;
        System.out.println("+100-     " + number);
    }

    private  synchronized void secondMethod() throws Exception {
        System.out.println("Method B ready to sleep");
         // 休息0.2S，阻塞队列,验证当前对象的机制锁被占用时，是否可以访问其他同步代码块
        Thread.sleep(20000);
        //this.wait(2000);
        TimeUnit.MINUTES.sleep(4L);
        /**
         * 使用notifyAll、wait、notify方法 需要添加锁.
         */
        System.out.println("wake up");
        number *= 200;
        System.out.println("*=200      -" + number);
    }

    @Override
    public void run() {
        System.out.println("Thread running");
        firstMethod();
    }

    public static void main(String[] args) throws Exception {
        SleepAndAwait sleepAndAwait = new SleepAndAwait();
        Thread thread = new Thread(sleepAndAwait);
        thread.start(); // 执行run里面的代码.
        System.out.println("prepare run second method");
        sleepAndAwait.secondMethod();
    }
}

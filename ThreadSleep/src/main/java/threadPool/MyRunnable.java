package threadPool;

import java.util.Date;

/**
 * @author jesse.hu
 * @date 2022/2/10 16:42
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }

}

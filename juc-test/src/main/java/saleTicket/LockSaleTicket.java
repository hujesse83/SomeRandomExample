package saleTicket;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jesse.hu
 * @date 2022/3/2 10:52
 */
public class LockSaleTicket {
    private int ticket = 30;
    private final ReentrantLock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try{
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出" + (ticket--) + "还剩" + ticket);
            }
        }finally {   // 如果中间出现了异常 会导致无法释放锁, 最好的方案就是try-finally 包裹
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockSaleTicket ticket = new LockSaleTicket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 30; j++) {
                    ticket.sale();
                }
            }, "Thread" + i).start(); // 使用start方法不一定立马创建线程, 由操作系统决定
        }
    }
}

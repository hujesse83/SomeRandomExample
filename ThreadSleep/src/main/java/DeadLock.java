/**
 * @author jesse.hu
 * @date 2022/2/10 14:15
 * <p>
 * 线程死锁的一个模拟
 */
public class DeadLock {
    private final static Object resource1 = new Object();//资源 1
    private final static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + " get resource2");
                }
            }
        }, "线程1").start();
        new Thread(() -> {
            synchronized (resource1) { // 将resource1 改为resource2
                System.out.println(Thread.currentThread() + "get resource2");

                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource2) {  // resource2 改为resource1   二行注释引起死锁
                    System.out.println(Thread.currentThread() + " get resource1");
                }
            }
        }, "线程2").start();
    }

    /*
    线程 A 通过 synchronized (resource1) 获得 resource1 的监视器锁，然后通过Thread.sleep(1000);让线程 A 休眠 1s 为的是让线程 B 得到执行然后获取到 resource2 的监视器锁。
    线程 A 和线程 B 休眠结束了都开始企图请求获取对方的资源，然后这两个线程就会陷入互相等待的状态，这也就产生了死锁。上面的例子符合产生死锁的四个必要条件。
     */

}

package communicate;

/**
 * @author jesse.hu
 * @date 2022/3/2 11:31
 * 线程之间的通信
 *
 *
 *前面这个A->C->A->B->A->C 会出现虚假唤醒的情况。
 *
 */
public class Demo1 {
    private int number = 0;

    public synchronized void incr() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"唤醒");
        if (number!=0){   // 应该改为while
            System.out.println(Thread.currentThread().getName() + "阻塞等待");
           this.wait();
        }
        System.out.println(Thread.currentThread().getName()+"::"+ ++number);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"唤醒");
        if (number!=1){  // 应该改为while
            System.out.println(Thread.currentThread().getName() + "阻塞等待");
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+"::"+  --number);
        this.notifyAll();
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();

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

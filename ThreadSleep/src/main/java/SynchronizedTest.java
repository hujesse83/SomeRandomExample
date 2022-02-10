import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jesse.hu
 * @date 2022/2/10 15:01
 */
public class SynchronizedTest {
    //1、synchronized 同步语句块
    public void method() {
        synchronized (this) {
            System.out.println("代码块");
        }
    }

    //2、synchronized修饰方法的时候

    /**
     * JVM 指令为ACC_SYNCHRONIZED，标识这是一个同步方法.
     */
    public synchronized void method2() {
        System.out.println("synchronized 修饰方法");
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        synchronizedTest.method2();
    }
    /*
    synchronized 同步语句块的实现使用的是 monitorenter 和 monitorexit 指令，
    其中 monitorenter 指令指向同步代码块的开始位置，monitorexit 指令则指明同步代码块的结束位置。
    如何锁住的对象是null、则会抛出NPE

    可见JVM monitorenter详解：https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-6.html#jvms-6.5.monitorenter

    ps:ReentrantLock 与synchronized 的区别
     */
}

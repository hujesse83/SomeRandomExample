package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jesse.hu
 * @date 2022/2/10 17:12
 * AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。
 */
public class AtomicIntegerTest {
    AtomicInteger count;

    //使用AtomicInteger之后，不需要对该方法加锁，也可以实现线程安全。
    public void increment() {
        count.incrementAndGet();
    }

    public AtomicIntegerTest() {
        count = new AtomicInteger();
    }

    public int getCount() {
        return count.get();
    }

}

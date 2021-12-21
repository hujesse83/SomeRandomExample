import java.util.BitSet;


/**
 * basically.we could see bitset.set()
 *         int wordIndex = wordIndex(bitIndex);
 *         words[wordIndex] |= (1L << bitIndex);
 *         其实我们是**64位操作系统**.左移65位等于又重新移回到了第一位. ***操作系统位数不同,jdk源码也有不一样的地方***
 */
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        System.out.println(1L << 65);
        System.out.println(1L << 1);
        System.out.println(1<<2);
        System.out.println(1<<3);
        System.out.println(1<<4);
        System.out.println(1<<65);
        System.out.println(1L << 64);
        bitSet.set(65);
        System.out.println(bitSet);
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(4));
        System.out.println(bitSet.get(101));
    }
}

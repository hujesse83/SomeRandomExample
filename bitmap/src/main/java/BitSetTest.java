import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i <100 ; i++) {
            bitSet.set(i);
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(4));
        System.out.println(bitSet.get(101));
    }
}

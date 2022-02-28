package dataStructrue;

import java.util.BitSet;

/**
 * @author jesse.hu
 * @date 2022/2/28 10:18
 */
public class BloomFilter {
    // 位数组的大小  即25位
    private static final int DEFAULT_SIZE = 1 <<24;
    // 用于构造hash函数的6个值
    private static final int[] SEEDS = new int[]{3,13,46,71,91,134};
    /**
     * 位数组、数组中的元素只能是 0 或者 1
     */
    private BitSet bitSet = new BitSet(DEFAULT_SIZE);

    /**
     * 存放包含hash 函数的类的数组
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * 初始化多个包含 hash函数的类的数组、每个类中的hash函数都不一样
     */
    public BloomFilter(){
        // 初始化多个不同的 Hash 函数
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }

    /**
     * 将元素添加到位数组
     */
    public void add(Object value) {
        for (SimpleHash f : func) {
            bitSet.set(f.hash(value), true);
        }
    }
    /**
     * 判断指定元素是否存在于位数组中
     */
    public boolean contains(Object value){
        boolean res = true;
        for (SimpleHash simpleHash : func) {
            res = bitSet.get(simpleHash.hash(value)) && res;
        }
        return res;
    }
    /**
     * 静态内部类、用于hash操作
     */
    public static class SimpleHash{
        private int cap;
        private int seed;
        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }

    public static void main(String[] args) {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        BloomFilter filter = new BloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        System.out.println(2<<24);
        System.out.println(1<<25);
    }

}

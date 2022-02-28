package dataStructrue;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author jesse.hu
 * @date 2022/2/28 11:20
 * Guava 的bloom filter 只能单机使用/
 */
public class GuavaBloomFilter {
    public static void main(String[] args) {
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01
        );
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
// 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }
}

package java8.lambdaTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/2/24 09:34
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<Integer> strings = Arrays.asList(1, 2, 3);
        Collections.sort(strings, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        Collections.sort(strings,(o1,o2)->o2-o1);
    }
}

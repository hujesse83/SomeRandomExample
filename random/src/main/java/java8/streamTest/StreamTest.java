package java8.streamTest;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jesse.hu
 * @date 2022/2/24 09:48
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "def", "gkh", "abc");
        // 返回符合条件的stream
        strings.stream().filter("abc"::equals);
        Stream<String> stringStream = strings.stream().filter(s -> "abc".equals(s));
        // 计算符合条件的流的数量
        long count = stringStream.count();

        // for-each 打印元素
        strings.forEach(System.out::println);

        Stream<String> limit = strings.stream().limit(1);
        limit.toArray(String[]::new);

        strings.stream().map(s->s+"22");

        strings.stream().filter("abc"::equals).collect(Collectors.toList());

        strings.stream().filter(String::isEmpty).collect(Collectors.joining(","));


        strings.stream().limit(2).forEach(System.out::println);



        //统计
        List<Integer> number = Arrays.asList(1, 2, 5, 4);
        IntSummaryStatistics statistics = number.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("列表中最大的数 : "+statistics.getMax());
        System.out.println("列表中最小的数 : "+statistics.getMin());
        System.out.println("平均数 : "+statistics.getAverage());
        System.out.println("所有数之和 : "+statistics.getSum());
    }
}

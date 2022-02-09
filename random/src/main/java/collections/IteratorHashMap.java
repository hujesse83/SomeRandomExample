package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author jesse.hu
 * @date 2022/2/9 17:17
 * @LeetCodeNo
 */
public class IteratorHashMap {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        // 1、使用迭代器（Iterator）EntrySet 的方式进行遍历；
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        //2、使用迭代器（Iterator）KeySet 的方式进行遍历；
        Iterator<Integer> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()){
            Integer key = iterator2.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
        //3、ForEach EntrySet
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        //4、ForEach KeySet
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
        //5、Lambda
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
        //6、Stream 单线程
        map.entrySet().stream().forEach((entry)->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
        //7、Stream多线程 parallel
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });

        /**
         * 从以上结果可以看出 entrySet 的性能比 keySet 的性能高出了一倍之多，因此我们应该尽量使用 entrySet  来实现 Map 集合的遍历
         */
    }
}

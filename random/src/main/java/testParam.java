import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jesse.hu
 * @date 2022/2/8 17:01
 * 'Java 中将实参传递给方法（或函数）的方式是 值传递 ：
 * 如果参数是基本类型的话，很简单，传递的就是基本类型的字面量值的拷贝，会创建副本。
 * 如果参数是引用类型，传递的就是实参所引用的对象在堆中地址值的拷贝，同样也会创建副本
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class testParam {
    private String name;

    public static void main(String[] args) {
        List<Integer> ids = Stream.of(1, 2).collect(Collectors.toList());
        System.out.println(ids);
        change(ids);
        System.out.println(ids);
    }

    // 这里传递的形参 传递的是实参的地址
    private static void change(List<Integer> list) {
        list.clear();
    }

    private static class testParam2 {
        public static void main(String[] args) {
            testParam xiaoZhang = new testParam("小张");
            testParam xiaoLi = new testParam("小李");
            swap(xiaoZhang, xiaoLi);
            System.out.println("xiaoZhang:" + xiaoZhang.getName());
            System.out.println("xiaoLi:" + xiaoLi.getName());

        }

        public static void swap(testParam person1, testParam person2) {
            testParam temp = person1;
            person1 = person2;
            person2 = temp;
            System.out.println("person1:" + person1.getName());
            System.out.println("person2:" + person2.getName());
        }

    }

}

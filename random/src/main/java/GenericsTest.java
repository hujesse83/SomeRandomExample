import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/2/4 19:06
 * Generics是什么？什么是类型擦除？介绍一下常用的通配符
 * Java泛型是JDk5引入的一个新特性, 泛型提供了编译时类型安全检测机制, 该机制允许程序员在编译时检测到非法的类型.
 * .泛型的本质是参数化、也就是说所操作的数据类型被指定为一个参数.
 *
 * Java的泛型是伪泛型, 在运行期间, 所以的泛型信息都会被擦除掉.
 *
 * 泛型一般有三种 类 实例化泛型类时，必须指定T的具体类型
 * 接口 1、实现泛型接口，不指定类型 2、 实现泛型接口，指定类型
 * 方法 eg: public static <E> void printArray(E[] inputArray)
 *
 * 常用的通配符为： T，E，K，V，？
 * ？ 表示不确定的 Java 类型 T (type) 表示具体的一个 Java 类型 K V (key value) 分别代表 Java 键值中的 Key Value E (element) 代表 Element #
 *
 * 项目中使用的泛型: 1、定义通用返回结果 R<T> 可以通过T根据具体的返回类型动态指定结果的数据类型
 *                2、Excel处理类ExcelUtil<T> 用于动态指定导出的数据类型
 *                3、Collections中的sort

 */
public class GenericsTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(12);
//这里直接添加会报错
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
//但是通过反射添加是可以的
//这就说明在运行期间所有的泛型信息都会被擦掉
        add.invoke(list, "kl");
        System.out.println(list);
    }
}

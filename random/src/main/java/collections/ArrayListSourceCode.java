package collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * @author jesse.hu
 * @date 2022/2/9 14:13
 */
@Getter
@Setter
@AllArgsConstructor
public class ArrayListSourceCode {
    private String name ;

    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 2);
        a[2] = 99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        int[] a2 = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a2, 10);
        System.out.println("b.length  " + b.length);
        // 这里可以看到、如果不重写hashcode方法、二者的hashcode是不一样的
        ArrayListSourceCode arrayListSourceCode = new ArrayListSourceCode("1");
        ArrayListSourceCode arrayListSourceCode2 = new ArrayListSourceCode("1");
        System.out.println(arrayListSourceCode.hashCode());
        System.out.println(arrayListSourceCode2.hashCode());
    }
}

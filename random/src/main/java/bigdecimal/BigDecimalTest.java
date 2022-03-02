package bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author jesse.hu
 * @date 2022/2/9 11:23
 * add 方法用于将两个 BigDecimal 对象相加，
 * subtract 方法用于将两个 BigDecimal 对象相减。
 * multiply 方法用于将两个 BigDecimal 对象相乘，
 * divide 方法用于将两个 BigDecimal 对象相除。

 */
public class BigDecimalTest {
    public int a;
    private String b;
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal d = new BigDecimal("0.5");
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
        System.out.println(a.divide(d,6, RoundingMode.HALF_UP));

        if (x.compareTo(y)==0){
            System.out.println("true");
        }
        System.out.println(Objects.equals(x,y));
    }
}

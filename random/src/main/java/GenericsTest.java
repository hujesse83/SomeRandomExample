import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/2/4 19:06
 */
public class GenericsTest {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        Class<? extends List> listClass = list.getClass();
        System.out.println(listClass);
    }
}

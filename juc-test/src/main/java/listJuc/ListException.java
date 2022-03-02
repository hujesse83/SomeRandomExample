package listJuc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jesse.hu
 * @date 2022/3/2 14:31
 * 并发add 和读取会造成线程不安全问题. list的add方法并没有添加synchronized关键字
 */
public class ListException {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1、Vector
        //2、List<Integer> syncList = Collections.synchronizedList(list);
        //3、CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(new Random().nextInt());
                System.out.println(list);
            }, "i").start();
        }

    }
}

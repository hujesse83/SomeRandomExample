package listJuc;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author jesse.hu
 * @date 2022/3/2 14:48
 */
public class SetException {
    public static void main(String[] args) {
        // CopyOnWriteArraySet<Integer> writeArraySet = new CopyOnWriteArraySet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(new Random().nextInt());
                System.out.println(set);
            }, "i").start();
        }
    }
}

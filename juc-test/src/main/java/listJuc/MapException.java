package listJuc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jesse.hu
 * @date 2022/3/2 14:52
 */
public class MapException {
    public static void main(String[] args) {
        //ConcurrentHashMap<Integer,Integer> writeArraySet = new ConcurrentHashMap<Integer,Integer><>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                map.put(finalI, new Random().nextInt());
                System.out.println(map);
            }, "i").start();
        }
    }
}

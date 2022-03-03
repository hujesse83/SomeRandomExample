package queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author jesse.hu
 * @date 2022/3/3 09:48
 */
public class BolckingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

        System.out.println(queue.add("1"));
        queue.put("2");
    }
}

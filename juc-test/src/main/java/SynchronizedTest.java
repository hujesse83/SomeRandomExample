/**
 * @author jesse.hu
 * @date 2022/3/2 09:43
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 30; j++) {
                    ticket.sale();
                }
            }, "Thread" + i).start();
        }
    }
}


class Ticket {
    private int ticket = 30;

    public void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出" + (ticket--) + "还剩" + ticket);
        }
    }

}

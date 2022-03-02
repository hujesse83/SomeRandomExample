/**
 * @author jesse.hu
 * @date 2022/3/2 09:36
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread threadUser = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "     __" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "ThreadUser");
        // 设置为守护线程之后、当非守护线程运行结束、守护线程也运行结束。JVM终止
        threadUser.setDaemon(true);
        threadUser.start();


        System.out.println("main");

        /*
        main
        hreadUser     __false
        Process finished with exit code 130 (interrupted by signal 2: SIGINT)

         */
    }
}

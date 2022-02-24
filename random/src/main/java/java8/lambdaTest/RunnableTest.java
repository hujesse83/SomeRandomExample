package java8.lambdaTest;

/**
 * @author jesse.hu
 * @date 2022/2/24 09:31
 */
public class RunnableTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("the runnable is running");
            }
        }).start();

        new Thread(()->{
            System.out.println("it's lambda running" );
        }).start();
    }
}

package deadLock;

/**
 * @author jesse.hu
 * @date 2022/3/2 15:35
 */
public class Test {
    static Object A = new Object();
    static Object B = new Object();
    public static void main(String[] args) {
        new Thread(()->{
         synchronized (A){
             System.out.println("1");
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             synchronized (B){
                 System.out.println("2");
             }
         }
        }).start();
        new Thread(()->{
            synchronized (B){
                System.out.println("12");
                synchronized (A){
                    System.out.println("22");
                }
            }
        }).start();
    }
}

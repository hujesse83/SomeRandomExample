import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author jesse.hu
 * @date 2022/2/10 15:32
 * 通过这个实例、发现每个线程独有一份
 */
public class ThreadLocalTest implements Runnable{

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
    @Override
    public void run() {
        System.out.println("Thread name= " + Thread.currentThread().getName()+"default Formatter ="+ formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        }catch (Exception e){
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }


    public static void main(String[] args) throws Exception{
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        for (int i = 0; i <10 ; i++) {
            Thread t = new Thread(threadLocalTest,""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }
}

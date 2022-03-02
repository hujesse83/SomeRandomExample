package synchronizedFullTest;

/**
 * @author jesse.hu
 * @date 2022/3/2 14:56
 * 对于普通同步方法、锁的是当前实例对象
 * 对于静态同步方法，锁的是当前类的Class对象
 * 对于同步方法快，锁的是synchronized括号里配置的对象
 */
public class Phone {
    public  synchronized void sendSMS() throws Exception{
        Thread.sleep(4000);
        System.out.println("send Sms");
    }
    public  synchronized void sendEmail() throws Exception{
        System.out.println("send email");
    }
    public  void sayHi() throws Exception{
        System.out.println("Hello");
    }
    /**
     * Synchronized 的8个问题
     * 1、标准访问、打印机短信还是打印邮件
     * 2、停4s在短信方法中、先打印短信还是邮件
     * 3、新增普通的hello方法，先打短信还是hello
     * 4、二个手机，先短信还是先邮件
     * 5、二个静态同步方法，一个手机，谁先打印
     *6、二个静态同步问题。二个手机，谁先
     * 7、一个静态同步问题，一个普通方法，一个手机，谁先打印
     * 8、、一个静态同步问题，一个普通方法，2个手机，谁先打印
     */
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try{
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try{
                phone.sendEmail();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"BB").start();
    }
}

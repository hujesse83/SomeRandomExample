package proxy.staticProxy;

/**
 * @author jesse.hu
 * @date 2022/2/9 09:15
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message " + message);
        return message;
    }
}

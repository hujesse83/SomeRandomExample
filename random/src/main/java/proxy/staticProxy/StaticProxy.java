package proxy.staticProxy;

import lombok.AllArgsConstructor;


/**
 * @author jesse.hu
 * @date 2022/2/8 17:46
 * 由于代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐。
 */
@AllArgsConstructor
public class StaticProxy implements SmsService{

    private final SmsService smsService;

    @Override
    public String send(String message) {
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return message;
    }

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        StaticProxy smsProxy = new StaticProxy(smsService);
        smsProxy.send("java");
    }
}

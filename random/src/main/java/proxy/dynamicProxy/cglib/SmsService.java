package proxy.dynamicProxy.cglib;

/**
 * @author jesse.hu
 * @date 2022/2/9 10:30
 * JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类。
 * Cglib （Code Generation Library）可以代理普通类
 */
public class SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

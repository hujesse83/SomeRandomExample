package proxy.dynamicProxy.jdk;



/**
 * @author jesse.hu
 * @date 2022/2/9 09:31
 * JDK动态代理是利用反射机制在运行时创建代理类的。
 * JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类。
 */
public class MainTest {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        /**
         * 当我们的动态代理对象调用一个方法时，这个方法的调用就会被转发到实现InvocationHandler 接口类的 invoke 方法来调用。
         */
        smsService.send("java");
    }
}

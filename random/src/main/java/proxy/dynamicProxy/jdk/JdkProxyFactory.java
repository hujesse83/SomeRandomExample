package proxy.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author jesse.hu
 * @date 2022/2/9 09:23
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new MyInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}


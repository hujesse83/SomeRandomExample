package proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jesse.hu
 * @date 2022/2/9 09:26
 *增强对象
 */

public class MyInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     * 每一个代理的实例都会有一个关联的调用处理程序(InvocationHandler)
     */
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 当你使用代理对象调用方法的时候实际会调用到这个方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before method " + method.getName());
        method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return null;
    }
}

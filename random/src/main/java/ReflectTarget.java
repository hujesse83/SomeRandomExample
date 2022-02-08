
import lombok.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jesse.hu
 * @date 2022/2/8 17:30
 */
@ToString
public class ReflectTarget {
    private String value;

    public ReflectTarget() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /**
         * 获取TargetObject类的Class对象并且创建TargetObject类实例
         */
        Class<?> reflectTarget = Class.forName("ReflectTarget");
        ReflectTarget obj = (ReflectTarget) reflectTarget.newInstance();
        /**
         * 获取所有类中所有定义的方法
         */
        Method[] methods = reflectTarget.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        /**
         * 获取指定方法并调用
         */
        Method publicMethod = reflectTarget.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(obj, "Hello World");
        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = reflectTarget.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(obj, "JavaGuide");

        /**
         * 调用 private 方法
         */
        Method privateMethod = reflectTarget.getDeclaredMethod("privateMethod");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(obj);
    }
}

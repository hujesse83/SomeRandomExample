package java8.interfaceTest;

/**
 * @author jesse.hu
 * @date 2022/2/24 09:19
 */
public interface RandomMethod {
    int a = 4;   // 变量的默认修饰符
    public static final int b = 5;


    // 和类方法一样, 直接调用.
    static void sm(){
        System.out.println("static 方法");
    }

    // 普通实例方法
    default void def(){
        System.out.println("default 方法, 可以被this调用, 也可以被子类继承、重写");
    }

    //抽象方法
    public abstract void fun();


}

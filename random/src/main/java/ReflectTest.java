

/**
 * @author jesse.hu
 * @date 2022/2/8 17:14
 * 获取Class对象的四种方式. Class类对象将一个类的方法、变量等信息告诉运行的程序.
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、知道具体类的情况下
        Class<ReflectTest> class1 = ReflectTest.class;

        //2、传入类的路径获取：
        Class class2 = Class.forName("ReflectTestt");

        //3、通过对象实例
        ReflectTest reflectTest = new ReflectTest();
        Class<? extends ReflectTest> class3 = reflectTest.getClass();

        //3、通过类加载器
       ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class class4 =   classLoader.loadClass("ReflectTest");

    }

}

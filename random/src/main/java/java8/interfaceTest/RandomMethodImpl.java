package java8.interfaceTest;

/**
 * @author jesse.hu
 * @date 2022/2/24 09:23
 */
public class RandomMethodImpl implements RandomMethod {
    @Override
    public void fun() {
        System.out.println("实现接口的具体方法");
    }

    @Override
    public void def() {
        System.out.println("子类重写接口的实例方法");
    }

    public static void main(String[] args) {
        RandomMethod.sm();
        RandomMethod randomMethod = new RandomMethodImpl();
        randomMethod.def();
        randomMethod.fun();
        System.out.println(RandomMethod.a);
    }
}

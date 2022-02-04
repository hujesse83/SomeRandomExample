import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jesse.hu
 * @date 2022/2/4 14:51
 * 浅拷贝
 * 浅拷贝：浅拷贝会在堆上创建一个新的对象（区别于引用拷贝的一点），
 * 不过，如果原对象内部的属性是引用类型的话，浅拷贝会直接复制内部对象的引用地址，也就是说拷贝对象和原对象共用同一个内部对象。
 */
@Getter
@Setter
@AllArgsConstructor
public class classTest implements Cloneable{

    private final String name;

    /*Object本身没有实现Cloneable接口，所以不重写clone方法并且进行调用的话会发生Clon
    eNotSupportedException异常。
     */
    @Override
    protected classTest clone() throws CloneNotSupportedException {
        return (classTest)super.clone();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Person implements Cloneable{
        private classTest classTest;
        @Override
        protected Person clone() throws CloneNotSupportedException {
            return (Person)super.clone();  // 新开辟了一块地址、但是属性是浅拷贝, classTest是引用
        }

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        classTest demo = new classTest("hi");
        Person originPerson = new Person(demo);
        Person clonePerson = originPerson.clone();
        System.out.println(originPerson);
        System.out.println(clonePerson); // 可见clone是新开辟一块地址
        System.out.println(originPerson.getClassTest());
        System.out.println(clonePerson.getClassTest());
        System.out.println(originPerson.getClassTest()==clonePerson.getClassTest());
        System.out.println(originPerson.equals(clonePerson));
    }
}

import lombok.*;

/**
 * @author jesse.hu
 * @date 2022/2/4 14:51
 * 深拷贝
 *
 * 深拷贝 ：深拷贝会完全复制整个对象，包括这个对象所包含的内部对象
 */
@Getter
@Setter
@AllArgsConstructor
public class classTest2 implements Cloneable{

    private final String name;

    @Override
    protected classTest2 clone() throws CloneNotSupportedException {
        return (classTest2)super.clone();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Person implements Cloneable{
        private classTest2 classTest;
        @Override
        protected Person clone() throws CloneNotSupportedException {
            Person person = (Person) super.clone();
            person.setClassTest(person.getClassTest().clone()); // clone会新开辟一块空间
            return person;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        classTest2 demo = new classTest2("hi");
        Person originPerson = new Person(demo);
        Person clonePerson = originPerson.clone();
        System.out.println(originPerson);
        System.out.println(clonePerson);
        System.out.println(originPerson.getClassTest());
        System.out.println(clonePerson.getClassTest());
        System.out.println(originPerson.getClassTest()==clonePerson.getClassTest());
        System.out.println(originPerson.equals(clonePerson));
    }
}

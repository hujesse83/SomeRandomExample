/**
 * @author jesse.hu
 * @date 2022/2/10 14:46
 *
 *   ***双重检验锁方式实现单例模式***
 *   ***双重检验锁方式实现单例模式***
 *   ***双重检验锁方式实现单例模式***
 *   ***双重检验锁方式实现单例模式***
 */
public class SingletonTwoLock {
    /*
    　对于可见性，Java提供了volatile关键字来保证可见性以及有序性.
　　当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
     */
    private volatile static SingletonTwoLock uniqueInstance;

    public SingletonTwoLock() {
    }

    public static SingletonTwoLock getUniqueInstance(){
        // 先判断对象是否已经实例化过、没有实例化才进入加锁代码
        if (uniqueInstance == null){
            // 类对象加锁
            synchronized (SingletonTwoLock.class){
                if(uniqueInstance == null){
                    uniqueInstance = new SingletonTwoLock();
                }
            }
        }
        return uniqueInstance;
    }
}

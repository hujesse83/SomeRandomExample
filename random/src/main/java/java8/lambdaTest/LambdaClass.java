package java8.lambdaTest;

import java8.LamdbaInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author jesse.hu
 * @date 2022/2/24 09:37
 */
public class LambdaClass {
    public static void forEg() {
        lambdaInterfaceDemo(()-> System.out.println("自定义函数式接口"));
    }
    //函数式接口参数
    static void lambdaInterfaceDemo(LamdbaInterface i){
        i.f();
    }

    public static void main(String[] args) {
        LambdaClass.forEg();
        Map<Integer, String> map = new HashMap<>();
        map.forEach((k,v)->System.out.println(v));
    }

}

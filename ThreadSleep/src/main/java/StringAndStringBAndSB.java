/**
 * 执行代码 查看class字节码的区别
 */
public class StringAndStringBAndSB {
    public static void main(String[] args) throws Throwable {
        String s1 = "hello" ;
        String s2 = "world";
        String s3 = s1 + s2;
        String s4 = "hello world";
        System.out.println(s3==s4);
        cas();
    }
    public static void cas() throws Throwable{
        String str = "123a";
        int temp = Integer.parseInt(str);
    }
}

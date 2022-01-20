public class Son extends Parent{
    @Override
    public void say(){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.say();
    }
}

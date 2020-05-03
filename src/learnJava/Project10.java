package learnJava;
/*
对类的封装，限制属性和方法的使用
private  私有的，仅本类可以访问。
default  空，默认的，本包可以访问。
protected  子类可以访问。
public  所以类都可以访问。

多态：继承，重写，父类引用子类
 */
public class Project10 {
    public static void main(String[] args) {
        Father p1 = new Father();
        Child1 p2 = new Child1();
        Child2 p3 = new Child2();

        funn(p1);
        funn(p2);
        funn(p3);
    }

    static void funn(Father p){  //多态可以根据父类去引用子类。
        p.fun();
    }
//    static void funn(Child1 p){
//        p.fun();
//    }
//    static void funn(Child2 p){
//        p.fun();
//    }
}

class Father{
    public void fun(){
        System.out.println("执行Father类。");
    }
}
class Child1 extends Father{
    public void fun(){
        System.out.println("执行Child1类。");
    }
}
class Child2 extends Father{
    public void fun(){
        System.out.println("执行Child2类。");
    }
}
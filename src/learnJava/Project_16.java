package learnJava;

/**
 * 内部类
 *
 */
public class Project_16 {
    public static void main(String[] args) {
        //1.非静态内部类：先有外部类，后有内部类
        OuterClass.Inner inner = new OuterClass().new Inner();
        inner.show();

        //2.静态内部类：可以直接通过访问外部类的静态成员访问。
        OuterClass_2.Inner2 inner2 = new OuterClass_2.Inner2();

        //2.匿名内部类
        Project_16.testclass(new TT(){ //调用本类中的test方法
            public void tt(){
                System.out.println("正在调用TT接口创建的匿名类中的test方法");
            }
        });
    }

    public static void testclass(TT a){
        System.out.println("TT类型参数已经传入");
        a.tt();
    }

    //4.局部内部类
    void test2(){
        class classsss{}
        //作用域仅在方法内。

    }
}

class OuterClass{ //非静态内部类
    //定义属性和方法。
    private int age = 20;

    public void test() {
        System.out.println("测试OuterClass");
    }

    class Inner {// 内部类，会生成独立的类。
        //定义属性和方法
        int age = 19;
        public void show(){
            int age = 18;
            System.out.println("外部类的变量age = " + OuterClass.this.age); //外部类属性
            System.out.println("外部类的变量age = " + this.age); //内部类属性
            System.out.println("外部类的变量age = " + age); //内部类方法属性
        }
    }
}
/*
1.内部类可以直接访问外部类的属性和方法。
2.外部类不能访问内部类的成员。
3.普通内部类不能有static方法和属性，有静态成员必须为静态类。
4.外部类的静态方法不能访问非静态类。
 */

class OuterClass_2{  //静态内部类
    static class Inner2{

    }
}
/*
 * 1.静态内部类可以直接通过访问 外部类的静态成员访问。
 *   new 外部类.内部类（）；
 * 2.静态内部类存在时，不一定存在外部类对象，所以不能访问外部类的成员。
 */


interface TT{ //定义接口。
    void tt();
}
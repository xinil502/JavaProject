package learnJava;

/*
抽象方法和抽象类
 */
abstract public class Project_14 {
/*
1.抽象方法必须定义在抽象类里。
2.抽象类里可以写普通方法。
3.抽象类只能被继承，，不能new出对象。
 */
    abstract public void method();
    /*
    抽象方法：
    1.抽象类没有实现。
    2.子类必须实现。
     */

    public void print(){
        System.out.println("正在运行已经实现的普通方法。");
    }
}

class pp extends Project_14{
    public void method(){ //实现抽象父类中未实现的方法。
        System.out.println("正在运行子类实现的方法");
    }
}

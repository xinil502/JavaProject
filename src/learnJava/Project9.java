package learnJava;
/*
overload 方法重载
override 方法重写
1.方法名，形参列表相同。
2.返回值和声明异常，子类小于父类。
3.访问权限，父类大于子类
 */
public class Project9 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.goGoGo();

        RedCar car2 = new RedCar();
        car2.goGoGo();
    }
}

class Car{
    public void goGoGo(){
        System.out.println("by a car.");
    }
    public Person who(){
        return new Person();
    }
}

class RedCar extends Car{
    public void goGoGo(){
        System.out.println("by a red car.");
    }
    public Student who(){
        return new Student();
    }
}

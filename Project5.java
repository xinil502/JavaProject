package learnJava;
/*
 * 对象和类的使用—1
 *
 *
 */
public class Project5 {
    //属性fields
    int id;
    String name;
    int age;

    Computer comp; //计算机

    //方法
    void study(){
        System.out.println("我在认真学习。"+"使用电脑："+comp.brand);
    }
    void play(){
        System.out.println("我在玩游戏，王者农药！");
    }

    //构造方法，用于创建这个类的对象。无参的构造方法可以由系统自动创建
    //构造器的方法名必须与类名一致
    Project5(){

    }

    //程序执行的入口，必须要有
    public static void main(String[] arge){
        Project5 stu1 = new Project5();//创建一个对象
        stu1.id = 4193070;
        stu1.name = "任基伟";
        stu1.age = 19;

        Computer c1 = new Computer();
        c1.brand = "HASEE";
        stu1.comp = c1;

        stu1.study();
        stu1.play();
    }
}

class Computer{
    String  brand;
}
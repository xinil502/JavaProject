package learnJava;
/*
继承
super和this的区别
 */
public class Project8 {
    public static void main(String[] args) {
        Student stu1 = new Student("任基伟",173,"西邮");

        System.out.print(stu1.school+stu1.name);
        stu1.fun1();
        stu1.fun2();

        System.out.println(stu1 instanceof Student); //用于判断左边对象是不是属于右边类或右边类的子类（左边对象赋值给右边引用可以实现）
        System.out.println(stu1 instanceof Person); //学生是不是人？
        System.out.println(stu1 instanceof Object);
        System.out.println(new Person() instanceof Student);
    }
}
class Person{
    String name;
    int height;

    public void fun1(){
        System.out.println("已执行fun1");
    }


    public Person(){

    }
    public Person(String name, int height){
        this.name = name;
        this.height = height;
    }
}

class Student extends Person{  //继承并扩展person类（类只能单继承，接口可以多继承）
    String school;
    public void fun2(){
        System.out.println("已执行fun2");
    }
    /*
    super和this的区别

    super（参数）：调用基类中的某一个构造函数（应该为构造函数中的第一条语句）
    this（参数）：调用本类中另一种形成的构造函数（应该为构造函数中的第一条语句）
    super: 它引用当前对象的基类中的成员（基类与派生类有重写时，访问父类中被隐藏的成员数据或函数如：super.变量名    super.成员函数据名（实参））
    this： 它代表当前对象名(程序中容易引起异义时使用)
    super()必须写在子类构造方法的第一行，否则编译不通过。每个子类构造方法的第一条语句，都是隐含地调用super()，
    如果父类没有这种形式的构造函数，那么在编译的时候就会报错。

    super()和this()类似,区别是，super()从子类中调用父类的构造方法，this()在同一类内调用其它方法。
    super()和this()均需放在构造方法内第一行。
    尽管可以用this调用一个构造器，但却不能调用两个。
    this和super不能同时出现在一个构造函数里面，因为this必然会调用其它的构造函数，其它的构造函数必然也会有super语句的存在

    this()和super()都指的是对象，所以，均不可以在static环境中使用。包括：static变量,static方法，static语句块。
    从本质上讲，this是一个指向本对象的指针, 然而super是一个Java关键字。
     */
    public Student(){

    }
    public Student(String name, int height, String school){
        super(name,height);
        this.name = name;
        this.height = height;
        this.school = school;
    }
}
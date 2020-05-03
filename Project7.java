package learnJava;
/*
 * this的本质
 * static关键字，内存分析，静态变量和静态方法
 *
 * static声明的成员变量为静态成员变量（类变量），生命周期与类相同，在整个程序执行期间都有效。
 *
 * 静态变量、静态方法属于类信息中，类信息在方法区，没有对象，
 *对象的变量属于堆中
 *
 *有类不一定有对象，但有对象一定有类
 *所以静态方法中不能使用this，不能使用普通属性，也不能使用普通方法。
 *但对象可以使用static变量和方法
 */
public class Project7 {
    int a, b, c;

    //构造器可以重载
    Project7(int a, int b){
        this.a = a; //a自动认为是靠近的局部变量，this指向本类。或者可以定义两个不同的变量进行赋值。
        this.b = b;
    }


/*
    使用this(参数)调用本类构造器的其他构造方法。
    使用super(参数)调用父类构造器的构造方法。
    这两句必须位于构造器中的第一句。
 */
    Project7(int a, int b, int c){
        this(a,b);
        this.c =c;
    }

    void  sing(){
    }

    void eat(){
        this.sing();  //调用本类中的sing
        System.out.println("已调用eat方法！！");
    }
    /*
     *
     */
    public static void main(String[] arges){
        Project7 hi = new Project7(2,3);
        hi.eat();
    }
}

package learnJava;
//接口，实现抽象与具体实现的分离。
//【访问修饰符】 interface 接口名 【extends 父接口1， 父接口2...】{
// （访问修饰符只能是public或默认，接口可以多继承）
//     常量定义; （不能定义变量，修饰总是public static final,，变量名习惯大写）
//     方法定义；  （修饰总是public abstract）
//}
interface Interface_1 {
    /*public static final*/ int AGE = 100;
    /*public abstract*/void test01();
}

/*
1.子类通过implements来实现接口的规范
 */
class Interface_1Class implements Interface_1{ //实现
    public void test01(){
        System.out.println(AGE);
        System.out.println("运行实现的test01");
    }
}


public class Project_15 {
    public static void main(String[] args) {
        Interface_1Class ifc = new Interface_1Class();
        ifc.test01();

        Couple cou = new Couple();
        cou.goodMan();
        cou.beautifulWoman();

        Man cman = new Couple(); //cman只认Man类型
        cman.goodMan();
        //cman.beautifulWoman();
    }
}

interface Man{
    void goodMan();
}

interface Woman{
    void beautifulWoman();
}

class Couple implements Man,Woman {

    public void goodMan() {
        System.out.println("He is a good man.");
    }

    public void beautifulWoman(){
        System.out.println("She is a beautiful woman.");
    }
}
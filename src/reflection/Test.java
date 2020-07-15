package reflection;

/**
 *
 * Class类介绍
 */
public class Test {
    public static void main(String[] args) {

        Person p = new Person();
        /**
         * Class类是反射的源头
         *
         * 一个JVM中只会有一个Class实例
         * 一个Class对象，是一个加载到JVM中的.class文件
         * 每个类的实例都会记得自己是由哪个Class实例生成的
         *
         * 通过Class可以完整的得到一个类中的完整结构。
         */

        //Class创建方式：
        Class c0 = Person.class; //通过类名创建
        Class c1 = p.getClass(); //通过类的实例 的getClass()方法创建
        try {
            //通过Class的静态方法获取
            //参数是类的全路径(包名+类名)
            Class c2 = Class.forName("reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

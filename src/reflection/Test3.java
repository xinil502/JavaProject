package reflection;

import java.lang.reflect.Constructor;

/**
 * 通过反射创建一个对象
 */
public class Test3 {
    public static void main(String[] args) {
        //使用反射的构造方法来创建对象
        try {
            Class c = Class.forName("reflection.Student");

            Object obj0 = c.newInstance(); //调用了类的无参公共构造器
            Student stu0 = (Student)obj0;
            stu0.moveWay();

            Constructor con1 = c.getConstructor(String.class, int.class); //调用公共类指定参数的构造方法。
            Object obj1 = con1.newInstance("rjw", 18);
            Student stu1 = (Student) obj1;
            stu1.school = "西安邮电大学";
            System.out.println(stu1.school + stu1.name + stu1.age);

            Constructor con2= c.getDeclaredConstructor(String.class); //可以获取所有的指定参数的构造方法
            con2.setAccessible(true); //解除私有的封装，接下来就可以调用这个方法了。
            Object obj2 = con2.newInstance("西安邮电大学");
            Student stu2 = (Student) obj2;
            System.out.println((stu2).school);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

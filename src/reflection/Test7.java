package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 *
 * 反射调用指定属性
 *
 * get调用本类和父类的 public 信息（包括继承，但只包括public）
 * getDeclare调用本类的所有属性（包括所有封装,但不包括继承）
 */
public class Test7 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("reflection.Student");
            Constructor con  = c.getConstructor();
            Object obj = con.newInstance();
            Student stu = (Student)obj;

            stu.name = "某某人";
            Field f = c.getField("name");
            System.out.println(f.get(stu));
            f.set(stu, "某某");
            System.out.println(f.get(stu));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

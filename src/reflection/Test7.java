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
            Class c = Class.forName("reflection.Student");//反射获取类
            Constructor con  = c.getConstructor();//获取构造器
            Object obj = con.newInstance();//构造对象
            Student stu = (Student)obj;//转为对应对象

            Field f = c.getField("name"); //确定要操作的属性f
            f.set(stu, "某某");//修改属性值
            System.out.println(f.get(stu));//获取属性值
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

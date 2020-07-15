package reflection;

import java.lang.reflect.Field;

/**
 * 获取类的属性和包
 * 加上declare 可以获取所有数据
 */
public class Test5 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("reflection.Student");


            Field[] fs = c.getFields(); //获取类的公有属性，包含父类的
//            Field[] fs = c.getDeclaredFields(); //获取本类的所有属性（不包括父类），包括私有。

            for(Field f: fs){
                System.out.println("属性名" + f.getName());
                System.out.println("修饰符" + f.getModifiers());
                System.out.println("属性的类型" + f.getType());

            }



            Package p = c.getPackage(); //获取类所在的包
            System.out.println(p.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

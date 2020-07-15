package reflection;

/**
 * 获取类的构造的名称，修饰符，参数类型
 */

import java.lang.reflect.Constructor;

public class Test2 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("reflection.Student");

            Constructor[] cons1 = c.getConstructors();//获取类共有的构造方法
            int i=1;
            for(Constructor temp: cons1){
                System.out.print("构造方法" + i + ":" + temp);

                //.getModifiers()1代表public,2代表private,0代表default
                System.out.print("   修饰符是：" + temp.getModifiers());
                ++i;

                Class[] param = temp.getParameterTypes();
                System.out.print("参数类型是：");
                for(Class ty: param){
                    System.out.print(ty.getName() + "|");
                }
            }

            System.out.println();
            System.out.println("##################");
            Constructor[] cons2 = c.getDeclaredConstructors(); //获取类所有的构造方法
            i=1;
            for(Constructor temp: cons2){
                System.out.print("构造方法" + i + ":" + temp);

                System.out.print("   修饰符是：" + temp.getModifiers() + "  ");
                ++i;

                Class[] param = temp.getParameterTypes();
                System.out.print("参数类型是：");
                for(Class ty: param){
                    System.out.print(ty.getName() + "|");
                }
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

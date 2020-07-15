package reflection;
/**
 * 获取类的方法
 */

import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("reflection.Student");

            Method[] ms = c.getMethods(); //获取类的公有的方法。
//            c.getDeclaredMethods(); 获取所有的公有的方法
            for(Method m: ms){
                System.out.print("方法名" + m.getName());
                System.out.print("返回值类型:" + m.getReturnType());
                System.out.print("修饰符" + m.getModifiers());

                Class[] pcs = m.getParameterTypes();
                System.out.print("参数类型");
                for(Class pc: pcs){
                    System.out.print(pc);
                }
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

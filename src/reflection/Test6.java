package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 调用指定的方法
 */
public class Test6 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("reflection.Student");
            Constructor con  = c.getConstructor();
            Object obj = con.newInstance();

            /**
             * 不论下面调用什么方法，都调用的是obj对象的方法
             * obj对象实际上就是Student对象。
             *
             * 1.调用重载方法时,修改getMethod（）后面的参数就可以了。
             * 2. invoke的返回值就是 方法的返回值。
             */

            // 获取方法需要两个参数：方法名。  参数类型(0 - 多个)
            Method m = c.getMethod("moveWay2", int.class, int.class);
//            Method m = c.getDeclaredMethod("moveWay"); //调用私有方法
//            m.setAccessible(true);  //解除私有
            //使用方法需要两个参数：实例化对象，当前方法的 实际参数
            System.out.println(m.invoke(obj,2,3)); //调用方法

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

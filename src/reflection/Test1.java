package reflection;

/**
 * 反射获取类的父类和接口
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("reflection.Student");

            Class cp = c.getSuperclass();//获取父类
            System.out.println(c + "的父类：" + cp);

            Class[] interfaces = c.getInterfaces();//获取当前类的所有接口
            int i=1;
            for(Class temp: interfaces){
                System.out.println(c + "的接口" + i + ":" + temp);
                ++i;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

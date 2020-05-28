package learnJava;
/*
 * 基本数据类型对应的包装类
 * Int     Integer
 * char    Character
 *
 */
public class Project_19 {
    public static void main(String[] args) {
        //基本数据类型转为包装类
        Integer b = Integer.valueOf(127); //推荐使用这种装箱，超出缓存，会new一个对象
        Integer a = new Integer(127); //创建新的包装类，而不是调用缓存

        //包装类转为基本数据类型
        int c = a.intValue(); //拆箱
        double d = a.doubleValue();

        //把字符串转为包装类
        Integer e = new Integer("666"); //传入字符串 调用下面的parseInt 进制强制为10进制
        Integer f = Integer.parseInt("111",2); //radix进制可不传，默认为10进制，Character类没有该方法

        /*
         * 自动拆装箱写省略了，其实执行内容没有省略：
         * Integer.valueOf()
         * num1.intValue
         */
        Integer num1 = 127;
        int num2 = num1;  //此时如果num1对象为空，则会报错

        /*
         * Integer.valueOf() 包装和Integer.parseInt()属于静态方法
         * a.intValue() 是非静态方法，必须现有对象才能使用
         * 包装类和基本数据类型比较时是比较值相等
         * Byte Short Integer Long 在-128，127之间，Character在0，127之间，会从缓存中取，
         * 其他的是new出来的新对象
         */
    }
}

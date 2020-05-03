package learnJava;

/*
 * 数据类型
 */
import java.math.BigDecimal;

public class Project1 {//第一个类
    /*
     * 整型和浮点类型测试
     */
    public static void main(String[] args) {//方法名，主入口
        // TODO Auto-generated method stub
        byte a = 30;
        short b = 30000;
        int c =100000000;
        long d = 1000000000000L;  //末尾加L转为long类型
        System.out.println(a+b+c+d);
        System.out.println(012);  //8进制
        System.out.println(0x12); //16进制
        System.out.println(0b1010);  //2进制

        System.out.println("Nice");
        double $a123 = 1.0/10;
        float $123 = 0.1F;
        System.out.println($a123==$123);
        float d1 = 423432423f;
        float d2 = d1+1;
        System.out.println(d1 == d2);

        System.out.println("小数计算使用函数避免误差");
        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd); //0.5
        System.out.println(1.0-0.1-0.1-0.1-0.1-0.1); //0.5000000000000001

        BigDecimal bd2 = BigDecimal.valueOf(0.1);
        BigDecimal bd3 = BigDecimal.valueOf(1.0/10);
        System.out.println(bd2.equals(bd3));

        char c1 = 'R';
        System.out.println(c1);
        char c2 = '任';
        System.out.println(c2);
        System.out.println('a'+'b');//自动转为数字
        System.out.println('a'+'b'+"");
        System.out.println(""+'a'+'\t'+'b'); //最前面加入空字符串即可
        System.out.println('a'+""+'b');

        boolean man = true;
        if(man){
            System.out.println("男性");
        }
        /*
         * 自动类型转换：容量小的数据类型可以自动转换为容量大的数据类型（附图）
         * 强制类型转换    (type)var
         */
    }
}
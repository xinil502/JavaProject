package learnJava;

import java.util.Arrays;

/*
 * 字符串学习，字符串与字符数组转换。
 * 字符串和字符数组：
 * String是java的字符串类，被final修饰，不能被继承。
 * java中字符串是常量，一旦被初始化就不可以被改变。
 * 对String对象的任何改变，都是返回一个新的String对象。
 *
 * 字符串和数组都有length方法，所以没有必要用空字符（\0）去控制结尾.
 *
 */
public class Project_12 {
    public static void main(String[] args) {
        //String类，不可变字符数组储存
        String a = "abcd";   //位于常量池中。
        String b = new String("abcd");  //位于堆中。
        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println(a.charAt(2)); //提取单个字符
        System.out.println(a.length()); //获得字符串长度
        System.out.println(a.equals(b)); //比较字符串是否值相等
        System.out.println(a.equalsIgnoreCase("AbcD")); //比较字符串值（忽略大小写）
        System.out.println(a.indexOf('b')); //寻找对应字符，字符串的索引值
        System.out.println(a.indexOf("cd"));
        System.out.println(a.indexOf("ac")); //未找到则返回-1

        String s = a.replace('b', 'c');
        System.out.println(s.indexOf("ac"));
        System.out.println(s);

        System.out.println(s.startsWith("a")); //是否以字符串"a"开头
        System.out.println(s.endsWith("c")); //是否以字符串"c"结尾
        s = b.toUpperCase(); //转大写
        System.out.println(s);
        s = s.toLowerCase(); //转小写
        System.out.println(s);
        System.out.println(s.substring(2));
        System.out.println(s.substring(1,3));
        //startIndex,endIndex截取字符串，前闭后开
        s.trim(); //去除首位的空格


        //字符数组转字符串
        char[] aa = new char[10];
        aa[0] = '1';
        aa[1] = '2';
        String string = new String(aa);
        System.out.println(string);
        /**
        new String() 用 "字符串直接量" 或 "字符数组" 创建字符串对象。
        但是像：a="123";  String str = new String(a);  会创建两个字符串对象。

        public static String valueOf(char data[]) {   //实际上也是调用new String()
            return new String(data);
        }
        public String(char value[]) {
            this.value = Arrays.copyOf(value, value.length);
        }
         */
        //字符串转字符数组
        System.out.println("字符串转字符数组：");
        String str = "apple";
        char[] ch = str.toCharArray();
        System.out.println(Arrays.toString(ch)); //import java.util.Arrays;原格式输出数组
    }
}

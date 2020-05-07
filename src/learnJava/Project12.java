package learnJava;

import java.util.Arrays;

/*
*字符串和字符数组：
* String是java的字符串类，被final修饰，不能被继承。
* java中字符串是常量，一旦被初始化就不可以被改变。
* 对String对象的任何改变，都是返回一个新的String对象。
*
* 字符串和数组都有length方法，所以没有必要用空字符（\0）去控制结尾.
*
 */
public class Project12 {
    public static void main(String[] args) {
        char[] a = new char[10];
        a[0] = '1';
        a[1] = '2';
        String string = new String(a);
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
        System.out.println(string);


        System.out.println("字符串转字符数组：");
        String str = "apple";
        char[] ch = str.toCharArray();
        System.out.println(Arrays.toString(ch)); //import java.util.Arrays;原格式输出
        System.out.println(ch[2]);
        System.out.println(ch.length);


        String[] str1 = { "J", "a", "v", "a", "中" };
        String[] str2 = { "如", "何", "把", "两", "个", "数", "组", "合", "并", "为",
                "一", "个" };
        int strLen1 = str1.length;// 保存第一个数组长度
        int strLen2 = str2.length;// 保存第二个数组长度
        str1 = Arrays.copyOf(str1, strLen1 + strLen2);// 扩容
        System.arraycopy(str2, 0, str1, strLen1, strLen2);// 将第二个数组与第一个数组合并
        System.out.println(Arrays.toString(str1));// 输出数组

    }
}

package learnJava;

/*
 * String 类和StringBuilder 可变字符序列
 */

public class Project_20 {
    public static void main(String[] args) {
        String a1 = "abc";
        //private final char value[]; 用常量数组储存

        //字符串优化
        String s1 = "ab" + "cd"; //编译器知道结果为abcd，相当于s1 = "abcd";
        String s2 = "abcd";
        System.out.println(s1 == s2);
        String a = "ab", b = "cd";
        String s3 = a+b; //编译器不知道a，b是谁，所以不会做优化。
        System.out.println(s2 == s3);

        //StringBuilder 线程不安全，效率高(一般用它)
        //StringBuffer 线程安全，效率低
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        sb.setCharAt(1,'z');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);


    }
}

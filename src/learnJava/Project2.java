package learnJava;

import java.util.Scanner;

/*
 * 运算符的使用
 * Scanner输入数据
 */
public class Project2 {
    public static void main(String[] args){
        /*
         * 整数运算：
         * 有long结果为long，，无long，结果为int
         * 浮点运算：
         * 有double结果为double，，无doube，结果为float
         * 取余运算：
         * 可以为浮点数，一般使用整数，余数的符号与左边操作数相同
         * 7%3=1           7%-3=1         -7%3=-1
         * int 可以给float   float不能给int
         */
        //  & |  && ||(短路运算)  ^异或  !非
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(!(b1&b2));

        /*
         * 3     0011
         * 5     0101
         * ————----------
         * &     0001  按位与     1
         * |     0111  按位或     7
         * ^     0110  按位异或   6
         *
         * <<  左移    3<<2  相当于3*2*2
         * >>  右移    32>>2 相当于32/2/2
         * ~   取反~a
         */
        int a = 3;
        int b = 5;
        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(a^b);
        System.out.println(~b);

        /*
         * 字符串连接符   ‘+’
         * 只要旁边有一个字符串，，加号就表示连接字符串
         */
        String $x = "3";
        int $y = 4;
        int $z = 5;
        char k = 'a';  //unicode 97
        System.out.println($x+$y+$z);
        System.out.println($y+$z+$x);
        System.out.println(k+4);  //字符区别于字符串 97+4

        /*
         * 条件运算符
         *     x ? true return : false return;    x为bollean类型
         */
        int score = 80;
        System.out.println(score<60?"不及格":"及格");

        if(score<60){
            System.out.println("不及格");
        }
        else{
            System.out.println("及格");
        }


        /*
         * Scanner 输入数据：
         *next()和nextLIne()都是字符串
         *next()在接收到有效数据前，所有的空格或者tab键等输入被忽略，
         *若有有效数据，则遇到这些键退出。
         *nextLine()可以接收空格或者tab键，其输入应该以enter键结束。
         *
         *nextInt()读入整数
         *nextDouble()读入双精度数。
         *
         */
        Scanner s = new Scanner(System.in);  //构造输入对象，标准输入流

        System.out.println("请输入你的名字：");
        String name = s.next();
        System.out.println("请输入你的年龄：");
        int age = s.nextInt(); //输入其他类型会报错
        System.out.println("请输入你的爱好：");
        String favor = s.nextLine();// 这条语句用于跳过上次读取的int数据后的回车换行符。
        favor = s.nextLine();
        s.close();    //若没有关闭s对象会给出警告！

        System.out.println("#########");
        System.out.print(name);
        System.out.print("    "+age);
        System.out.print("    "+favor);

    }
}
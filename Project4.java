package learnJava;
/*
 *方法的使用，递归
 *
 *参数传递为值传递，但传递值为对象时，传递的是地址，改变地址处的值，两个对象变量都会发生改变。
 */
import java.util.Scanner;

public class Project4 {
    public static void main(String[] arges){

        System.out.println("请输入阶乘数：");
        Scanner s = new Scanner(System.in);

        long a = s.nextInt(),i;
        s.close();

        Project4 m = new Project4();   //给方法加static，，可以直接引用。
        long aa = m.fun(a);
        System.out.println(a+"! = "+aa);


        long d3 = System.currentTimeMillis();
        for(i=1, aa=1; i<=a;++i){
            aa *=i;
        }
        long d4 = System.currentTimeMillis();
        System.out.println(a+"! = "+aa);
        System.out.println("time2 = "+(d4-d3));

    }

    public long fun(long n){
        if(n == 1){
            return 1;
        }else{
            return n*fun(n-1);
        }
    }
}

package math;

//不使用+-*/和for ,while, if,switch,?:实现 +-*/
//用位运算实现+-*/,,,用短路运算实现条件判断。

public class Project_1 {
    public static void main(String[] args) {
        //加法：不计进位的和为sum = a^b，进位就是a&b,完成加法直到进位为0
        System.out.println(add(12, -4));

        //减法：求负数（先按位取反，再加一，首位取反得负数原码，其余位取反加一得补码），再相加，
        System.out.println(minus(8,3));

        //if, else , ?:, switch使用短路运算实现
        int n = 10;
        boolean a = (n>10) && (--n) ==0;
        //乘法,最暴力的方法就是一直累加，，除此之外还可以位运算快速乘
        System.out.println(multiply(7, 999));

        //除法，最暴力的方法就是循环减，，除此之外还可以从2的整数幂倍开始减

        //有些循环使用递归传参改变循环变量实现

    }
    static int add(int a, int b){
        int sum = a;
        while(b != 0){
            sum = a ^ b;//不计进位的和
            b = (a & b) << 1; //进位的值
            a = sum;//不计进位的和
        }
        return sum;
    }
    static int negative(int num){
        return add(~num, 1);
    }
    static int minus(int a, int b){
        return add(a, negative(b));
    }
    static int multiply(int a, int b){
        if(a==0 || b==0){
            return 0;
        }
        int res = 0;
        boolean bool = (a^b) < 0;
        if(b<0) {
            b = negative(b);
        }
        if(a<0){
            a = negative(a);
        }
        for(int i=0; i<31; ++i){ //共判断31次
            res = res<<1;
            if((b & 1073741824) == 1073741824){
                res = add(res, a);
            }
            b = b<<1;
        }
        if(bool){
            return  negative(res);
        }
        return res;
    }
}

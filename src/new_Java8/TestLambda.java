package new_Java8;

public class TestLambda {
    public static void main(String[] args) {
        //1.基础语法
        LambdaNoneReturnNoneParameter lambda0 = ()->{
            System.out.println("lambda1");
        };
        LambdaNoneReturnSingleParameter lambda1 = (a)->{
            System.out.println(a);
        };
        LambdaSingleReturnNoneParameter lambda2 = ()->{
            return 3;
        };
        LambdaSingleReturnSingleParameter lambda3 = (a) -> {
            return a*a;
        };
        LambdaSingleReturnMutipleParameter lambda4 = (a, b) ->{
            return a*b;
        };
        lambda0.test(); //输出lambda。
        lambda1.test(97);  //原样输出int。
        System.out.println(lambda2.test()); //返回3。
        System.out.println(lambda3.test(5));  //返回参数的平方。
        System.out.println(lambda4.test(4, 5)); //返回参数的乘积。
    }
}

@FunctionalInterface
interface LambdaNoneReturnNoneParameter{
    void test();
}

@FunctionalInterface
interface LambdaSingleReturnNoneParameter{
    int test();
}

@FunctionalInterface
interface LambdaNoneReturnSingleParameter{
    void test(int a);
}

@FunctionalInterface
interface LambdaSingleReturnSingleParameter{
    int test(int a);
}

@FunctionalInterface
interface LambdaSingleReturnMutipleParameter{
    int test(int a, int b);
}

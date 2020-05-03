package learnJava;
/*
 * 判断循环语句
 */
public class Project3 {
    public static void main(String[] arges){
        double a = Math.random(); //生成范围在[0,1)的随机数
        System.out.println(a);
        int b = (int)(6*a+1.0);
        if(b>3){
            System.out.println("Big.");
        }else{
            System.out.println("Small");
        }

        System.out.println(Math.PI*Math.pow(a, 2));  //计算半径为a的圆形面积


    }
}

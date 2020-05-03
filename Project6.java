package learnJava;
/*
 * 对象和类的使用—2
 */
class Point {
    double x, y;

    //构造方法与类名保持一致，，用于new调用
    //构造器虽然有返回值，但是不能定义返回值的类型
    //不能在构造器里面用return；
    //有参数的构造器如下
    public Point(double _x, double _y){
        x = _x;
        y = _y;
    }

    //构造器也可以重载
    public Point(double _x){
        x =_x;
    }
    public double getDistance(Point p){
        return Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2));
    }
}


public class Project6{
    public static void main(String[] arges){
        Point p = new Point(4.0, 3.0); //构造对象，返回地址
        Point o = new Point(0, 0);
        System.out.println(p.getDistance(o));
    }
}
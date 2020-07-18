package thread;


/**
 * 实现死锁
 */
public class LearnThread_6 {
    public static void main(String[] args) {
        //创建两个被线程共享的对象
        IoClass ioObject = new IoClass(10);
        OutClass outObject = new OutClass(10);

        //创建两个Runnable实现类对象 (基于io，out)
        Runnable r1 = new Run1(ioObject, outObject);
        Runnable r2 = new Run2(ioObject, outObject);

        //创建两个线程
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "r2");

        t1.start();
        t2.start();

    }
}


class IoClass {
    static int a;

    public IoClass(int aa) {
        a = aa;
    }

    public void io() {
        System.out.println("正在调用io类对象的io方法, a = " + a);
    }
}


class OutClass {
    int a;

    public OutClass(int a) {
        this.a = a;
    }

    public void out() {
        System.out.println("正在调用out类对象的out方法,a = " + a);
    }
}


class Run1 implements Runnable{
    IoClass ioObject;
    OutClass outObject;

    public Run1(IoClass io, OutClass out) {
        this.ioObject = io;
        this.outObject = out;
    }

    @Override
    public void run() {
        synchronized (ioObject){
            System.out.println(Thread.currentThread().getName() + "锁定io对象");
            synchronized (outObject){
                System.out.println(Thread.currentThread().getName() + "锁定out对象，开始工作：");
                ioObject.io();
                outObject.out();
            }
        }

    }
}



class Run2 implements Runnable{
    IoClass ioObject;
    OutClass outObject;

    public Run2(IoClass io, OutClass out) {
        this.ioObject = io;
        this.outObject = out;
    }

    @Override
    public void run() {
        synchronized (outObject){
            System.out.println(Thread.currentThread().getName() + "锁定out对象");
            synchronized (ioObject){
                System.out.println(Thread.currentThread().getName() + "锁定io对象，开始工作：");
                ioObject.io();
                outObject.out();
            }
        }

    }
}
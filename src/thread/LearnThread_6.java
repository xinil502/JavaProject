package thread;


/**
 * 线程的死锁
 * 举例：
 * 某计算机系统中只有一台打印机和一台输入设备，
 * 进程P1正占用输入设备，同时又提出使用打印机的请求，
 * 但此时打印机正被进程P2所占用，而P2在未释放打印机之前，
 * 又提出请求使用正被P1占用着的输入设备。
 * 这样两个线程相互无休止地等待下去，均无法继续执行
 * ，此时两个线程陷入死锁状态。
 *
 * 死锁产生原因：
 * 1.线程运行调用太多公共资源，公共资源数量少。
 * 2.线程推进顺序不当。
 * 3.死锁产生的条件：
 *      1.进程互斥，对资源进行排他性控制。
 *      2.不强行剥夺进程资源，只能由使用的线程主动释放。
 *      3.请求和保持，请求其他资源时持有自己的资源。
 *
 * 避免死锁：加锁顺序，枷锁时限，枷锁检测。
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
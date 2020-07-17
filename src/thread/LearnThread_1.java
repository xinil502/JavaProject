package thread;

/*
 * 程序是未运行的代码
 * 进程是运行起来的代码
 * 线程是进程开出的支流
 */

/**
 *
 * 多线程的创建与启动
 *
 * run方法： 多线程运行中的代码逻辑通过写在run方法里来完成操作
 *   run方法的主体称为线程体
 * start方法： 开始调用当前对象的线程(本质上就是开始运行run方法)。
 *
 *
 * 创建线程一： 继承Tread类
 * 1.定义子类继承Thread类
 * 2.子类重写Thread中的run方法
 * 3.创建Thread子类对象，及创建了线程对象(可选择自定义命名)。
 * 4.调用线程对象的start方法：启动线程，调用run方法
 */

public class LearnThread_1 {
    public static void main(String[] args) {
        Thread t = new TestThread();
        t.start();//启动线程
//        t.run();  //不启动多线程，在进程中执行run()方法。

        Thread t2 = new TestThread("t2");
        t2.start();

        /*
         * 运行多次发现两个线程中的run方法打印顺序是不固定的
         * start()方法相当于开启了一个直流，两段代码同时运行，互不影响。
         * 控制台输出的就是并行的运行结果。 各自保持运行数据。异步性(相对于主程序)。
         *
         */
    }
}


class TestThread extends Thread{


    public TestThread() {
        super();
    }

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":多线程运行的代码：");
        for(int i=0; i<5; ++i){
            System.out.println(Thread.currentThread().getName()+":逻辑代码" + i + "。");
        }
    }
}

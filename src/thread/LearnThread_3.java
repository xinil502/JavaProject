package thread;

/**
 * Thread类的有关方法。
 *
 * void start(); //启动线程，调用run方法。
 * run();  //线程在被调用时执行的操作。
 * String getName();  //返回线程的名称。  默认名称Thread-i(i为创建的顺序)。
 * void setName();   //设置该线程名称。
 * static currentThread(); //返回当前线程。
 *
 *
 * 线程的优先级(有哪些线程有较大概率被执行，,并不是绝对优先)：
 * 优先级用数字1-10表示，数字越大，优先级越高，（没有设置，默认是5）
 * getPriority(); 返回优先值
 * setPriority(int newPriority);修改优先值
 */
public class LearnThread_3 {
    public static void main(String[] args) {
        TestRun tr = new TestRun();
        Thread t0 = new Thread(tr, "进程0");
        Thread t1 = new Thread(tr, "进程1");

        System.out.println(t0.getPriority() + "|" + t1.getPriority());
        t0.setPriority(1);
        t1.setPriority(10);

        t0.start();
        t1.start();



    }
}

class TestRun implements Runnable{
    int count;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":多线程运行的代码：");
        for(int i=0; i<5; ++i){
            System.out.println(Thread.currentThread().getName() + ":逻辑代码" + i + "。" + "count = " + ++count);
        }
    }
}

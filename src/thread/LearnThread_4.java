package thread;

/**
 * Thread类的有关方法2：
 *
 * static void yield(); //线程让步： （不是很明显）
 * 让步给优先级相同或者更高的线程去执行，
 * 如果没有更高的线程，则忽略此方法
 *
 * static void sleep(long millis); //睡眠(毫秒数)
 *
 * join();//在程序执行流中调用此方法，将暂时阻塞进程main方法，
 * 直到join()方法加入的join线程执行完为止，
 *
 * stop(); //在主程序中立刻结束某线程
 *
 * boolean isAlive(); //判断某线程是否存活
 *
 * yield 和 sleep是静态方法，可以通过类直接调用，
 * 其他的方法是成员方法，需要在主函数中通过对象调用，或者在run方法中调用当前对象的成员方法
 */
public class LearnThread_4 {
    public static void main(String[] args) {
        TestRun2 tr = new TestRun2();
        Thread t0 = new Thread(tr);
        Thread t1 = new Thread(tr);


        t0.start();
        t1.start();

        System.out.println("#############################  1");
        System.out.println("#############################  2");
        try {
            t0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("#############################  3");
    }
}


class TestRun2 implements Runnable{
    int count;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":多线程运行的代码：");
        for(int i=0; i<5; ++i){
            Thread.yield();//当前线程进行一次让步
            try {
                Thread.sleep(1000); //当前线程睡眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":逻辑代码" + i + "。" + "count = " + ++count);
        }
    }
}

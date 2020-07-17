package thread;


/**
 *
 * 创建线程二：实现Runnable接口实现多线程
 * 1.定义Runnable接口的实现类
 * 2.实现类重写Thread中的run方法
 * 3.创建Runnable接口实现类的对象
 * 3.创建Thread对象，及创建了线程对象，传入实现类对象作为参数(可选择自定义命名)。
 * 4.调用线程对象的start方法：启动线程，自动调用run方法。
 *
 *
 * Runnable实现类的优点：
 * 避免了单继承的局限性，，同时可以创建很多一样的多线程，共享同一个实例。
 *
 */
public class LearnThread_2 {


    public static void main(String[] args) {
        Runnable r = new TestRunnable();
        Thread t1 = new Thread(r);
        //Thread t1 = new Thread(new TestRunnable);
        t1.start();

        /**
         * 创建线程时传入字符串作为线程名称，，在run方法中可以获取线程名称
         * 便于观察线程异步方式。
         */

        Thread t2 = new Thread(r, "线程t2");
        //Thread t = new Thread(new TestRunnable, 线程t2");
        t2.start();


    }
}



class TestRunnable implements Runnable{

    int count = 0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":多线程运行的代码：");
        for(int i=0; i<5; ++i){
            System.out.println(Thread.currentThread().getName() + ":逻辑代码" + i + "。" + ++count);
        }
    }
}
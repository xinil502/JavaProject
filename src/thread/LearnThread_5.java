package thread;

/*
 * 线程的生命周期(从生到死的经历)
 *
 * 新建：线程实例创建
 * 就绪：被start()后，具备了运行条件
 * 运行：run()方法的代码开始执行
 * 阻塞：碰到特殊情况，暂停执行。
 * 死亡：线程结束（自然死亡）
 *      强行提前终止（强制死亡） 执行stop，断电，杀掉进程
 */

/**
 * 线程的同步与死锁
 */

public class LearnThread_5 {
    public static void main(String[] args) {
        Acount a = new Acount(3000);
        User u_vx = new User(a,2000);
        Thread t_vx = new Thread(u_vx, "微信支付");

        User u_zfb = new User(a,2000);
        Thread t_zfb = new Thread(u_zfb, "支付宝支付");

        t_vx.start();  //a对象的drawing1方法
        t_zfb.start(); //a对象的drawing2方法

    }
}

class Acount {

    public static int money = 0;


    public Acount() {
    }

    public Acount(int money) {
        this.money = money;
    }

    /**
     * 多线程调用方法，共享全局变量money。
     * 容易导致共享的资源在操作时有问题。
     * <p>
     * <p>
     * 解决思路：先让一个线程整体执行完，再让另一个线程执行。
     *
     * 通过synchronized同步锁来完成，在代码上加同步锁，
     * 一个对象只能与一个锁关联，两个方法都会想锁定当前对象，是互斥的。
     * 因此在同一时刻只能有一个线程得到执行，另一个线程受阻塞。
     * 只有当线程执行完该代码块才能释放该对象锁，下一个线程才能锁定该对象。
     * <p>
     * 如果这两个线程分别依附于同一类的两个对象，则不会发生互斥。
     * 此时可以通过将方法改为静态来实现对类的所有对象加同步锁
     * <p>
     * 一个线程访问synchronized代码块时，另一个线程的非synchronized代码仍然可以运行。
     *
     * @param getMoney
     */

    public synchronized void drawing1(int getMoney) {
        String name = Thread.currentThread().getName();
        if (money < getMoney) {
            System.out.println(name + "账户余额不足");
            return;
        }
        System.out.println(name + "账户原有金额" + money);

        System.out.println(name + "账户取款:" + money + "-" + getMoney);
        money -= getMoney;

        System.out.println(name + "取款后余额" + money);

    }

    public synchronized void drawing2(int getMoney) {
        String name = Thread.currentThread().getName();
        if (money < getMoney) {
            System.out.println(name + "账户余额不足");
            return;
        }
        System.out.println(name + "账户原有金额" + money);

        System.out.println(name + "账户取款:" + money + "-" + getMoney);
        money -= getMoney;

        System.out.println(name + "取款后余额" + money);

    }

/**
 * 对部分代码块加锁， 目标是对象(此处是当前对象)。
 *synchronized (Object object){}；
 *
 * 实现不同对象不同锁：
 * public void drawing1(int getMoney, Acount a){
 *      synchronized (a){
 *
 *      }
 * }
 *
 *
 */
/*
    public void drawing1(int getMoney){
        String name = Thread.currentThread().getName();
        System.out.println(name + "开始运行");
        synchronized (this){
            if(money < getMoney){
                System.out.println(name + "账户余额不足");
                return;
            }
            System.out.println(name + "账户原有金额" + money);

            System.out.println(name + "账户取款:" + money + "-" + getMoney);
            money -= getMoney;

            System.out.println(name + "取款后余额" + money);
        }
    }

    public void drawing2(int getMoney){
        String name = Thread.currentThread().getName();
        System.out.println(name + "开始运行");
        synchronized (this){
            if(money < getMoney){
                System.out.println(name + "账户余额不足");
                return;
            }
            System.out.println(name + "账户原有金额" + money);

            System.out.println(name + "账户取款:" + money + "-" + getMoney);
            money -= getMoney;


            System.out.println(name + "取款后余额" + money);
        }
    }
}

*/

}



class User implements Runnable{
    Acount a;
    int getMoney;

    public User(Acount a, int getMoney) {
        this.a = a;
        this.getMoney = getMoney;
    }

    @Override
    public void run() {
        //a.drawing1(getMoney);
        if(Thread.currentThread().getName().equals("微信")){
            a.drawing1(getMoney);
        }else{
            a.drawing2(getMoney);
        }
    }
}


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


package thread;


/**
 * 线程通信 wait(), notify(),notifyAll()
 *
 * wait(): 令当前线程挂起并放弃CPU，共享资源。
 *    使别的线程可访问并修改共享资源，当前线程排队等候。
 * notify()：唤醒排队等候同步资源的线程优先级高者结束等待,进入就绪状态。
 * notifyAll()：唤醒所有排队等待资源的线程结束等待。
 *
 * 这三个方法只能在：线程所调用的synchronized方法或代码块中使用，
 * 不然报异常：java.lang.IllegalMonitorStateException
 *
 */
public class LearnThread_7 {
    public static void main(String[] args) {
        Acounts a = new Acounts(3000);
        Users u_vx = new Users(a,2000);
        Thread t_vx = new Thread(u_vx, "微信支付");

        Users u_zfb = new Users(a,2000);
        Thread t_zfb = new Thread(u_zfb, "支付宝支付");

        t_vx.start();
        t_zfb.start();
    }
}


class Acounts {
    public static int money = 0;
    public Acounts(int money) {
        this.money = money;
    }

    public synchronized void drawing(int getMoney) {
        String name = Thread.currentThread().getName();

        if(Thread.currentThread().getName().equals("微信支付")){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (money < getMoney) {
            System.out.println(name + "账户余额不足");
            return;
        }
        System.out.println(name + "账户原有金额" + money);

        System.out.println(name + "账户取款:" + money + "-" + getMoney);
        money -= getMoney;

        System.out.println(name + "取款后余额" + money);

        this.notify();
    }
}



class Users implements Runnable{
    Acounts a;
    int getMoney;

    public Users(Acounts a, int getMoney) {
        this.a = a;
        this.getMoney = getMoney;
    }

    @Override
    public void run() {
        //a.drawing1(getMoney);
        a.drawing(getMoney);
    }
}


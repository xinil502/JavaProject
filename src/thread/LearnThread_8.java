package thread;

/**
 *
 * 生产者与消费者
 *
 */
public class LearnThread_8 {
    public static void main(String[] args) {
        //创建店铺，设置店铺最大储存为20。
        Cleck cleck = new Cleck(20);

        //设置生产和卖出 ，各创建两个Runnable实现类对象
        RunProduceFood produce1 = new RunProduceFood(cleck);
        RunProduceFood produce2 = new RunProduceFood(cleck);
        RunSaleFood sale1 = new RunSaleFood(cleck);
        RunSaleFood sale2 = new RunSaleFood(cleck);

        //创建生产和卖出线程， 各两个。
        Thread produceThread1 = new Thread(produce1, "一号生产线");
        Thread produceThread2 = new Thread(produce2, "二号生产线");
        Thread saleThread1 = new Thread(sale1, "一号售货台");
        Thread saleThread2 = new Thread(sale2, "二号售货台");

        sale1.setNum(19);
        saleThread1.start();

        produce1.setNum(18);
        produceThread1.start();

        produce2.setNum(15);
        produceThread2.start();

        sale2.setNum(14);
        saleThread2.start();
    }
}


class Cleck {
    public static int food = 0;
    public int size;

    public Cleck(int size) {
        this.size = size;
    }

    public synchronized void produce(int num) {
        try {
            while(num + food > size) {

                System.out.print(Thread.currentThread().getName()+"成功进货:" + food);
                num -= size-food;
                food = size;
                System.out.println(" -> " + food + " 柜台已满，还有" + num + "件货物生产者已生产");
                this.wait();
                this.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.print(Thread.currentThread().getName()+"成功进货:" + food);
        food += num;
        System.out.println(" -> " + food);

        this.notify();
    }

    public synchronized void sale(int num) {
        try {
            while(num > food) {
                System.out.print(Thread.currentThread().getName()+"成功卖出:" + food);
                num -= food;
                food = 0;
                System.out.println(" -> " + food + " 柜台已空，还有" + num + "件货物被消费者需要。");

                this.wait();
                this.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print(Thread.currentThread().getName()+"成功卖出:" + food);
        food -= num;
        System.out.println(" -> " + food);

        this.notify();
    }
}


/**
 * 生产线程
 */

class RunProduceFood implements Runnable{
    Cleck cleck;
    int num;

    public int getNum() {
        return num;
    }

    public RunProduceFood setNum(int num) {
        this.num = num;
        return this;
    }


    public RunProduceFood(Cleck cleck) {
        this.cleck = cleck;
    }

    @Override
    public void run() {
        cleck.produce(num);
    }
}


/**
 * 出售线程
 */
class RunSaleFood implements Runnable{
    Cleck cleck;
    int num;

    public RunSaleFood(Cleck cleck) {
        this.cleck = cleck;
    }

    public int getNum() {
        return num;
    }

    public RunSaleFood setNum(int num) {
        this.num = num;
        return this;
    }

    @Override
    public void run() {
        cleck.sale(num);
    }
}
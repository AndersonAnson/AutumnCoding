package thread;

//生产者线程和消费者线程
//共享数据是商品
class Clerk {
    private int productCount = 0;

    public synchronized void produceProduct() {// 同步监视器是this 确保底下的方法也共用一把锁
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount);
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized void comsumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount);
            productCount--;
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        super();
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName() + "开始生产产品");
        while (true) {
            clerk.produceProduct();
        }
    }

}

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        super();
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName() + "开始消费产品");
        while (true) {
            clerk.comsumeProduct();
        }
    }

}

public class ProducerAndConsumer {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        t1.start();
        t2.start();
    }

}
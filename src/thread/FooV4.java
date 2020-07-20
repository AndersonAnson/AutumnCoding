package thread;

public class FooV4 {
    private int flag = 0;//下面使用了锁已经保证内存可见性，就不需要volatile了
    //定义Object对象为锁
    private Object lock = new Object();

    public FooV4() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            //如果flag不为0则让first线程等待，while循环控制first线程如果不满住条件就一直在while代码块中，防止出现中途跳入，执行下面的代码，其余线程while循环同理
            while (flag != 0) {
                lock.wait();
            }
            printFirst.run();
            flag = 1;
            //唤醒其余所有的线程
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            printThird.run();
            flag = 0;
            lock.notifyAll();
        }
    }
}

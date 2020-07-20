package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooV5 {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();
    private int count = 1;

    public FooV5() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        reentrantLock.lock();
        printFirst.run();
        count = 2;
        condition.signalAll();
        reentrantLock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        reentrantLock.lock();
        //为什么这里可以使用if,而下面必须使用while呢
        //如果线程一运行完,线程三拿到了锁,则需要再次判断count值让其进入等待池
        if (count != 2) {
            condition.await();
        }
        printSecond.run();
        count = 3;
        condition.signalAll();
        reentrantLock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        reentrantLock.lock();
        while (count != 3) {
            condition.await();
        }
        printThird.run();
        reentrantLock.unlock();
    }
}

package test.oppo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class RunnableOne implements Runnable {

    @Override
    public void run() {
        System.out.println("A");
    }
}

class RunnableTwo implements Runnable {

    @Override
    public void run() {
        System.out.println("B");
    }
}

class RunnableThree implements Runnable {

    @Override
    public void run() {
        System.out.println("C");
    }
}

public class ThreadDemo {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();
    private static volatile int count = 1;

    public static void main(String[] args) throws InterruptedException {
        RunnableOne runnableOne = new RunnableOne();
        RunnableTwo runnableTwo = new RunnableTwo();
        RunnableThree runnableThree = new RunnableThree();
        Thread threadOne = new Thread(runnableOne);
        Thread threadTwo = new Thread(runnableTwo);
        Thread threadThree = new Thread(runnableThree);
        while (true) {
            if (count == 1) {
                reentrantLock.lock();
                threadOne.run();
                count = 2;
                condition.signalAll();
                reentrantLock.unlock();
            } else if (count == 2) {
                reentrantLock.lock();
                if (count != 2) {
                    condition.await();
                }
                threadTwo.run();
                count = 3;
                condition.signalAll();
                reentrantLock.unlock();
            } else if (count == 3) {
                reentrantLock.lock();
                while (count != 3) {
                    condition.await();
                }
                threadThree.run();
                count = 1;
                condition.signalAll();
                reentrantLock.unlock();
            }
        }
    }
}

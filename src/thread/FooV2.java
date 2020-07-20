package thread;

import java.util.concurrent.CountDownLatch;

public class FooV2 {
    private CountDownLatch c2;
    private CountDownLatch c3;

    public FooV2() {
        c2 = new CountDownLatch(1);
        c3 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        c2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        c2.await();
        printSecond.run();
        c3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c3.await();
        printThird.run();
        c3.countDown();
    }
}

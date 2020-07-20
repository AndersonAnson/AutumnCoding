package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class FooV3 {
    private AtomicInteger firstJobFinished = new AtomicInteger(0);
    private AtomicInteger secondJobFinished = new AtomicInteger(0);

    public FooV3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobFinished.compareAndSet(0, 1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobFinished.get() != 1) {

        }
        printSecond.run();
        secondJobFinished.compareAndSet(0, 1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobFinished.get() != 1) {

        }
        printThird.run();
    }
}

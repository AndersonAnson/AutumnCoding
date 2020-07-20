package thread;

import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore s1;
    private Semaphore s2;
    private Semaphore s3;
    public Foo() {
        s1=new Semaphore(1);
        s2=new Semaphore(0);
        s3=new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        s1.acquire(1);
        printFirst.run();
        s2.release(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //只有s2为1才能执行acquire，如果为0就会产生阻塞
        s2.acquire(1);
        printSecond.run();
        s3.release(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire(1);
        printThird.run();
        s3.release(1);
    }
}

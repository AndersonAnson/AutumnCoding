package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class FooBarV2 {
    private int n;
    private CountDownLatch countDownLatch;
    private CyclicBarrier cyclicBarrier;// 使用CyclicBarrier保证任务按组执行

    public FooBarV2(int n) {
        this.n = n;
        countDownLatch = new CountDownLatch(1);
        cyclicBarrier = new CyclicBarrier(2);// 保证每组内有两个任务
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        try {
            for (int i = 0; i < n; i++) {
                printFoo.run();
                countDownLatch.countDown();// printFoo方法完成调用countDown
                cyclicBarrier.await();// 等待printBar方法执行完成
            }
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            for (int i = 0; i < n; i++) {
                countDownLatch.await();// 等待printFoo方法先执行
                printBar.run();
                countDownLatch = new CountDownLatch(1);//重置
                cyclicBarrier.await();
            }
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

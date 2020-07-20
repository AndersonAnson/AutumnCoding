package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(6);
        System.out.println("init:now" + semaphore.availablePermits() + "lanes available");
        //创建10个任务（相当于10个游泳者）
        for (int i = 1; i <= 10; i++) {
            final int number = i;
            executor.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "swimmer" + number + " acquire " + "remaining" + semaphore.availablePermits() + "lanes available");
                    Thread.sleep(1000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "swimmer" + number + " release " + "remaining" + semaphore.availablePermits() + "lanes available");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}

package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerForBlockingQueue implements Runnable {
    protected BlockingQueue<String> queue = null;

    public ProducerForBlockingQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ConsumerForBlockingQueue implements Runnable {
    protected BlockingQueue<String> queue = null;

    public ConsumerForBlockingQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);
        ProducerForBlockingQueue producer = new ProducerForBlockingQueue(queue);
        ConsumerForBlockingQueue consumer = new ConsumerForBlockingQueue(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        Thread.sleep(4000);
    }
}
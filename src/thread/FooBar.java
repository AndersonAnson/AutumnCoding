package thread;

public class FooBar {
    private int n;
    private volatile int flag = 1;

    public FooBar(int n) {
        this.n = n;

    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag != 1) {
                    this.wait();
                }
                printFoo.run();
                flag = 2;
                this.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag != 2) {
                    this.wait();
                }
                printBar.run();
                flag = 1;
                this.notifyAll();
            }
        }
    }
}

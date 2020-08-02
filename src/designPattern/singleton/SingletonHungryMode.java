package designPattern.singleton;

public class SingletonHungryMode {
    private static SingletonHungryMode singletonHungryMode = new SingletonHungryMode();

    private SingletonHungryMode() {

    }

    public static SingletonHungryMode getInstance() {
        return singletonHungryMode;
    }
}

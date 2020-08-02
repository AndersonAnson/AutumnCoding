package designPattern.singleton;

public class SingletonOuterClass {
    private static class SingletonInterClass {
        private static final SingletonOuterClass INSTANCE = new SingletonOuterClass();
    }

    private SingletonOuterClass() {

    }

    public static final SingletonOuterClass getInstance() {
        return SingletonInterClass.INSTANCE;
    }
}

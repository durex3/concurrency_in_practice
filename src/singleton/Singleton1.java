package singleton;

/**
 * 饿汉式(线程安全)
 * @author gelong
 * @date 2020/6/25 23:38
 */
public class Singleton1 {

    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }
}

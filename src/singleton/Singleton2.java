package singleton;

/**
 * 懒汉式(线程不安全)
 * @author gelong
 * @date 2020/6/25 23:38
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

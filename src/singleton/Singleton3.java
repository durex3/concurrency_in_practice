package singleton;

/**
 * 懒汉式(线程安全)
 * @author gelong
 * @date 2020/6/25 23:38
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

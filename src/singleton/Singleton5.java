package singleton;

/**
 * 懒汉式(最优)
 * @author gelong
 * @date 2020/6/25 23:38
 */
public class Singleton5 {

    private static volatile  Singleton5 instance;

    private Singleton5() {}

    public static synchronized Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

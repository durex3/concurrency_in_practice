package singleton;

/**
 * 懒汉式(有瑕疵)
 * @author gelong
 * @date 2020/6/25 23:38
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {}

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

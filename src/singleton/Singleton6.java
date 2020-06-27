package singleton;

/**
 * 静态内部类
 * @author gelong
 * @date 2020/6/25 23:38
 */
public class Singleton6 {

    private Singleton6() {}

    private static class Single {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Single.INSTANCE;
    }
}

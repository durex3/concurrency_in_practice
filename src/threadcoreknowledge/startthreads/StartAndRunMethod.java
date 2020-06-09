package threadcoreknowledge.startthreads;

/**
 * @author gelong
 * @date 2020/6/1 21:39
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();
        new Thread(runnable).start();
    }
}

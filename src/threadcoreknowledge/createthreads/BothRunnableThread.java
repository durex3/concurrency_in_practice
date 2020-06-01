package threadcoreknowledge.createthreads;

/**
 * @author gelong
 * @date 2020/5/30 1:07
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("我来自Runnable");
        }) {

            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}


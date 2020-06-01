package threadcoreknowledge.createthreads;


/**
 * @author gelong
 * @date 2020/5/30 0:36
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("继承Thread类");
    }

    public static void main(String[] args) {
        ThreadStyle thread = new ThreadStyle();
        thread.start();
    }
}

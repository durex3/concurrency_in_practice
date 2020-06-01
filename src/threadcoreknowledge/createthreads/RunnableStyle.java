package threadcoreknowledge.createthreads;

/**
 * @author gelong
 * @date 2020/5/30 0:30
 */
public class RunnableStyle implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}

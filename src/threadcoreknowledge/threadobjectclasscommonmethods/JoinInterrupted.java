package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/18 22:47
 */
public class JoinInterrupted {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        Thread threadA = new Thread(() -> {
            main.interrupt();
        });
        threadA.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "响应了中断");
            e.printStackTrace();
        }
    }
}

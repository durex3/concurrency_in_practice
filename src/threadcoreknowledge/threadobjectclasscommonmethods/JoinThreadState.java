package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/18 23:36
 */
public class JoinThreadState {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        Thread threadA = new Thread(() -> {
            System.out.println(main.getName() + "：" + main.getState());
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

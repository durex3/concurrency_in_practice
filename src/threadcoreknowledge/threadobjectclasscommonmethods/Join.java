package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/18 22:35
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });
        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });
        threadA.start();
        threadB.start();
        System.out.println("开始等待子线程执行");
        threadA.join();
        threadB.join();
        System.out.println("所有子线程执行完毕");
    }
}

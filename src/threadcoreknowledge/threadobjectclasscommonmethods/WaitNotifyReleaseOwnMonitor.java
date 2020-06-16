package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/15 21:25
 */
public class WaitNotifyReleaseOwnMonitor {

    private final static Object resourceA = new Object();
    private final static Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + "获取锁A");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + "获取锁B");
                    try {
                        System.out.println(Thread.currentThread().getName() + "准备释放锁A");
                        resourceA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + "获取锁A");
                System.out.println(Thread.currentThread().getName() + "尝试获取锁B");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + "获取锁B");
                }
            }
        });
        threadA.start();
        Thread.sleep(100);
        threadB.start();
    }
}

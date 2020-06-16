package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/14 22:47
 */
public class WaitNotifyAll implements Runnable {

    private final static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            try {
                System.out.println(Thread.currentThread().getName() + "准备进入等待");
                object.wait();
                System.out.println(Thread.currentThread().getName() + "即将运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new WaitNotifyAll();
        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
        Thread threadC = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "唤醒所有线程");
                object.notifyAll();
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(100);
        threadC.start();
    }
}

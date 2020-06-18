package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/17 22:15
 */
public class SleepDontReleaseMonitor implements Runnable {

    @Override
    public void run() {
        sync();
    }

    private synchronized void sync() {
        System.out.println(Thread.currentThread().getName() + "获取了锁");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "退出同步代码块");
    }

    public static void main(String[] args) {
        Runnable runnable = new SleepDontReleaseMonitor();
        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
        threadA.start();
        threadB.start();
    }
}

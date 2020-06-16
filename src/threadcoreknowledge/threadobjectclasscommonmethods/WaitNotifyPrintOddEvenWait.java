package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/16 23:21
 */
public class WaitNotifyPrintOddEvenWait {

    private final static Object lock = new Object();
    private static int count = 0;

    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "：" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new TurningRunner();
        Thread threadA = new Thread(runnable, "偶数");
        Thread threadB = new Thread(runnable, "奇数");
        threadA.start();
        Thread.sleep(10);
        threadB.start();
    }
}

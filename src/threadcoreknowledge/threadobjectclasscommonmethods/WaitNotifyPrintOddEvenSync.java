package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/16 23:01
 */
public class WaitNotifyPrintOddEvenSync {

    private static final Object lock = new Object();
    private static int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + count++);
                    }
                }
            }
        }, "偶数").start();
        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + "：" + count++);
                    }
                }
            }
        }, "奇数").start();
    }
}

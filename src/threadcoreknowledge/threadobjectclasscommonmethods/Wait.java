package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @author gelong
 * @date 2020/6/11 23:10
 */
public class Wait {

    private final static Object object = new Object();

    static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                System.out.println(Thread.currentThread().getName() + "准备等待");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "被唤醒了");
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                System.out.println(Thread.currentThread().getName() + "唤醒其他线程");
                object.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        Thread.sleep(100);
        ThreadB ThreadB = new ThreadB();
        ThreadB.start();
    }
}

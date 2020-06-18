package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gelong
 * @date 2020/6/17 22:15
 */
public class SleepDontReleaseLock implements Runnable {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable runnable = new SleepDontReleaseLock();
        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
        threadA.start();
        threadB.start();
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

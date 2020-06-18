package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.TimeUnit;

/**
 * @author gelong
 * @date 2020/6/18 0:24
 */
public class SleepInterrupted implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new SleepInterrupted();
        Thread thread = new Thread(runnable);
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        thread.interrupt();
    }
}

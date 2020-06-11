package threadcoreknowledge.sixstates;

/**
 * @author gelong
 * @date 2020/6/11 21:43
 */
public class BlockedWaitingTimedWaiting implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        Thread.sleep(500);
        System.out.println(thread1.getName() + " " + thread1.getState());
        System.out.println(thread2.getName() + " " + thread2.getState());
        Thread.sleep(1200);
        System.out.println(thread1.getName() + " " + thread1.getState());
    }

    @Override
    public void run() {
        sync();
    }

    private synchronized void sync() {
        try {
            Thread.sleep(1000);
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

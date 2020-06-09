package threadcoreknowledge.stopthreads;

/**
 * @author gelong
 * @date 2020/6/3 23:24
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
        System.out.println("任务结束了");
    }
}

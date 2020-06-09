package threadcoreknowledge.stopthreads;

/**
 * run方法内没有sleep或者wait方法时，停止线程
 * @author gelong
 * @date 2020/6/3 22:16
 */
public class RightWayStopThreadWithoutSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= 100000) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
            }
        });
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
        System.out.println("任务结束了");
    }
}

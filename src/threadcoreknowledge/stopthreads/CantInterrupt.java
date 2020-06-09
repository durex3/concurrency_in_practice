package threadcoreknowledge.stopthreads;

/**
 * 抛出InterruptedException会清除中断标记
 * @author gelong
 * @date 2020/6/8 0:05
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= 10000) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("任务结束了");
    }
}

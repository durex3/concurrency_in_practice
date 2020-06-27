package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @author gelong
 * @date 2020/6/23 21:21
 */
public class OutOfOrderExecution {

    private static int x = 0;
    private static int y = 0;
    private static int a = 0;
    private static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            CountDownLatch latch = new CountDownLatch(3);
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread threadA = new Thread(() -> {
                latch.countDown();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 1;
                x = b;
            });
            Thread threadB = new Thread(() -> {
                latch.countDown();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b = 1;
                y = a;
            });
            threadA.start();
            threadB.start();
            latch.countDown();
            threadA.join();
            threadB.join();
            if (x == 0 && y == 0) {
                System.out.println("执行了" + i + "次 " + "x=" + x + ", y=" + y);
                break;
            }
            System.out.println("执行了" + i + "次 " + "x=" + x + ", y=" + y);
        }
    }
}

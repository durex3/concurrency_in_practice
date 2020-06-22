package background;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第一种：运行结果出错
 * 计数不准确（减少），找出具体出错的位置
 * @author gelong
 * @date 2019/12/23 23:06
 */
public class MultiThreadsError1 implements Runnable {

    private static int index = 0;
    private static MultiThreadsError1 instance = new MultiThreadsError1();
    private static AtomicInteger realIndex = new AtomicInteger();
    private static AtomicInteger wrongCount = new AtomicInteger();
    private final boolean[] marked = new boolean[100000];
    private static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    private static CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    @Override
    public void run() {
        marked[0] = true;
        for (int i = 0; i < 10000; i++) {
            try {
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();
            synchronized (instance) {
                if (marked[index] && marked[index - 1]) {
                    wrongCount.incrementAndGet();
                    System.out.println("发生错误: " + index);
                }
                marked[index] = true;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面上的结果是: " + index);
        System.out.println("真正的结果是: " + realIndex);
        System.out.println("错误次数: " + wrongCount);
    }
}

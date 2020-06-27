package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gelong
 * @date 2020/6/25 21:40
 */
public class NoVolatile implements Runnable {

    private static volatile int a = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            a++;
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NoVolatile noVolatile = new NoVolatile();
        Thread threadA = new Thread(noVolatile);
        Thread threadB = new Thread(noVolatile);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(a);
        System.out.println(atomicInteger.get());
    }
}

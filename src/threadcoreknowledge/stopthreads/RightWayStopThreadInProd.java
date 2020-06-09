package threadcoreknowledge.stopthreads;

/**
 * 在方法签名中抛出异常
 * @author gelong
 * @date 2020/6/9 21:31
 */
public class RightWayStopThreadInProd implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("停止线程");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(1000);
    }
}

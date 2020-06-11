package threadcoreknowledge.sixstates;

/**
 * @author gelong
 * @date 2020/6/11 21:17
 */
public class NewRunnableTerminated implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package background;

/**
 * 死锁
 * @author gelong
 * @date 2019/12/23 23:06
 */
public class MultiThreadsError2 implements Runnable {

    private int flag = 0;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 0) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(0);
                }
            }
        }
        if (flag == 1) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadsError2 r1 = new MultiThreadsError2();
        MultiThreadsError2 r2 = new MultiThreadsError2();
        r1.setFlag(0);
        r2.setFlag(1);
        new Thread(r1).start();
        new Thread(r2).start();
    }
}

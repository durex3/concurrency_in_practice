package background;


/**
 * 第一种：运行结果出错
 * 计数不准确（减少），找出具体出错的位置
 * @author gelong
 * @date 2019/12/23 23:06
 */
public class MultiThreadsError implements Runnable {

    private static int index = 0;
    private static MultiThreadsError instance = new MultiThreadsError();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;
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
    }
}

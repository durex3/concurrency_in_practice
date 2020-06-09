package threadcoreknowledge.startthreads;

/**
 * @author gelong
 * @date 2020/6/1 23:09
 */
public class CantStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}

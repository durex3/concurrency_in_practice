package jmm;

/**
 * @author gelong
 * @date 2020/6/23 23:20
 */
public class FieldVisible {

    int a = 1;
    int b = 2;
    private void change() {
        a = 3;
        b = a;
    }
    private void print() {
        System.out.println("b=" + b + ";a=" + a);
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            final FieldVisible test = new FieldVisible();
            Thread t1=new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.change();
            });

            Thread t2=new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.print();
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }

    }
}

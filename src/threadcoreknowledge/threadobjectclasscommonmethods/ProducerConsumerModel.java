package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author gelong
 * @date 2020/6/15 22:21
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage(10);
        Producer producerA = new Producer(storage);
        Producer producerB = new Producer(storage);
        Consumer consumerA = new Consumer(storage);
        Consumer consumerB = new Consumer(storage);
        new Thread(producerA).start();
        new Thread(producerB).start();
        new Thread(consumerA).start();
        new Thread(consumerB).start();
    }
}

class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.take();
        }
    }
}

class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage(int maxSize) {
        this.maxSize = maxSize;
        this.storage = new LinkedList<>();
    }

    public synchronized void put() {
        while (storage.size() == maxSize) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.addLast(new Date());
        System.out.println("仓库里有了" + storage.size() + "个产品");
        this.notifyAll();
    }

    public synchronized void take() {
        while (storage.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.removeFirst() + "还剩下" + storage.size() + "个产品");
        this.notifyAll();
    }
}
package models;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PubSub {

    private ReentrantLock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    private int MAX_SIZE = 10;

    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

//    private LinkedList<String> queue = new LinkedList<>();

    private void publish(int name) {
        lock.lock();
        try {
            while (queue.size() >= MAX_SIZE) {
                System.out.println("wait for consuming");
                notFull.await();
            }
            queue.offer(name+"_"+"message" );
            System.out.println(name +" publish message, size: "+queue.size());
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void consume(int name) {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("wait for publishing");
                notEmpty.await();
            }
            System.out.println(name+" consume: "+queue.poll()+"_"+queue.size());
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        PubSub pubSub = new PubSub();

        for (int i=0; i<2;i++) {
            final int name = i;
            new Thread() {
                @Override
                public void run() {
                    pubSub.consume(name);
                }
            }.start();
        }

        for (int i=0; i<30;i++) {
            final int name = i;
            new Thread() {
                @Override
                public void run() {
                    pubSub.publish(name);
                }
            }.start();
        }

    }
}

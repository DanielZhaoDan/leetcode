package models;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1234 {

    volatile private int index = 1;

    // 1,2,3,4,5,6,7,8,9,10
    public void print() {
        ReentrantLock lock = new ReentrantLock();

        Condition printOdd = lock.newCondition();
        Condition printEven = lock.newCondition();

        new Thread() {
            @Override
            public void run() {
                while (index < 10){
                    try {
                        lock.lock();
                        while (index % 2 == 0) {
                            printOdd.await();
                        }
                        System.out.println(index);
                        index = index + 1;
                        printEven.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (index <= 10){
                    try {
                        lock.lock();
                        while (index % 2 != 0) {
                            printEven.await();
                        }
                        System.out.println(index);
                        index = index + 1;
                        printOdd.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        ReentrantLock1234 main = new ReentrantLock1234();
        main.print();
    }
}

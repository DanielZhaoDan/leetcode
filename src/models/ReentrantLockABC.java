package models;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockABC {

    private int status = 1;

    private ReentrantLock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public static void main(String[] args) {
        ReentrantLockABC reentrantLockABC = new ReentrantLockABC();
        int times = 5;

        MyThread threadA = new MyThread(times, "A", reentrantLockABC);
        MyThread threadB = new MyThread(times, "B", reentrantLockABC);
        MyThread threadC = new MyThread(times, "C", reentrantLockABC);

        threadA.run();
        threadB.run();
        threadC.run();
    }

    public void printA() {
        lock.lock();
        try {
            while (status != 1) {
                c1.await();
            }
            System.out.println("A");
            status = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (status != 2) {
                c2.await();
            }
            System.out.println("B");
            status = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (status != 3) {
                c3.await();
            }
            System.out.println("C");
            status = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



}

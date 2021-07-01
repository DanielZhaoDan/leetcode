package models;

public class MyThread implements Runnable {

    private int count;

    private String name;

    private ReentrantLockABC reentrantLockABC;

    public MyThread(int count, String name, ReentrantLockABC reentrantLockABC) {
        this.count = count;
        this.name = name;
        this.reentrantLockABC = reentrantLockABC;
    }

    @Override
    public void run() {
        for (int i=0; i<count; i++) {
            switch (name) {
                case "A":
                    reentrantLockABC.printA();
                case "B":
                    reentrantLockABC.printB();
                case "C":
                    reentrantLockABC.printC();
                default:
                    break;
            }

        }
    }
}

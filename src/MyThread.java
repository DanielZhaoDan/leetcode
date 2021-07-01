import models.ReentrantLock1234;

public class MyThread implements Runnable {

    private ReentrantLock1234 main;

    public MyThread(ReentrantLock1234 main) {
        this.main = main;
    }

    @Override
    public void run() {

    }
}

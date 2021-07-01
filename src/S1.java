public class S1 extends Thread {

    private String name;

    private S1 next;

    public S1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }

    public S1 getNext() {
        return next;
    }

    public void setNext(S1 next) {
        this.next = next;
    }
}

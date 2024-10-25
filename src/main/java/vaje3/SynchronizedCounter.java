package vaje3;

public class SynchronizedCounter {

    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    // alt + insert to +generate code
    public int getCount() {
        return count;
    }
}

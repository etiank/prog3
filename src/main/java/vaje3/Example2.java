package vaje3;

import util.LogLevel;
import util.Logger;

public class Example2 {

    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example 2", LogLevel.Warn);

        SynchronizedCounter counter = new SynchronizedCounter();

        Thread t1 = new Thread(new SynchronizedCountingTask(counter));
        Thread t2 = new Thread(new SynchronizedCountingTask(counter));
        Thread t3 = new Thread(new SynchronizedCountingTask(counter));

        t1.start();
        t3.start();
        t2.start();

        t1.join();
        t2.join();
        t3.join();

        Logger.log("Count at the end: " + counter.getCount());
    }

}

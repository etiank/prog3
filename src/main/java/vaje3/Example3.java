package vaje3;

import util.LogLevel;
import util.Logger;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example 3");
        increment();
        incrementBoth();
        incrementSingle();
        Logger.log("Done");
    }

    private static void increment() throws InterruptedException {

        long start = System.currentTimeMillis();
        DoubleCounter counter = new DoubleCounter();

        Thread t1 = new Thread(new DoubleCountingTask(counter, CounterSelector.First));
        Thread t2 = new Thread(new DoubleCountingTask(counter, CounterSelector.First));
        Thread t3 = new Thread(new DoubleCountingTask(counter, CounterSelector.First));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        long end = System.currentTimeMillis();


        Logger.log("Time: " + (end-start) + "ms", LogLevel.Status );
        Logger.log("Counter at the end: " + counter.getCount1());

    }

    private static void incrementBoth() throws InterruptedException {

        long start = System.currentTimeMillis();
        DoubleCounter counter = new DoubleCounter();

        Thread t1 = new Thread(new DoubleCountingTask(counter, CounterSelector.First));
        Thread t2 = new Thread(new DoubleCountingTask(counter, CounterSelector.First));
        Thread t3 = new Thread(new DoubleCountingTask(counter, CounterSelector.First));
        Thread t4 = new Thread(new DoubleCountingTask(counter, CounterSelector.Second));
        Thread t5 = new Thread(new DoubleCountingTask(counter, CounterSelector.Second));
        Thread t6 = new Thread(new DoubleCountingTask(counter, CounterSelector.Second));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        long end = System.currentTimeMillis();


        Logger.log("Time: " + (end-start) + "ms", LogLevel.Status );
        Logger.log("Counter at the end: " + counter.getCount1());

    }

    private static void incrementSingle() throws InterruptedException {
        long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 300_000; i++) {
            count++;
        }
        long end = System.currentTimeMillis();
        Logger.log("Time single: " + (end-start) + "ms", LogLevel.Status );
    }
}

package org.vaje2;

import util.LogLevel;
import util.Logger;

public class CountingTask implements Runnable {

    private Counter counter;

    public CountingTask(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        Logger.log("Counting ..");
        for (int i = 0; i < 100_000; i++) {
            counter.count.incrementAndGet();
        }
        Logger.log("Done Counting.", LogLevel.Success);
    }

}

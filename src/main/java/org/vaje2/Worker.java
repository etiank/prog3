package org.vaje2;

import util.LogLevel;
import util.Logger;

import javax.security.auth.login.LoginException;

public class Worker extends Thread {

    //volatile - tell the var to ignore the cache and always check in memory
    private volatile boolean running = true;

    @Override
    public void run() {
        Logger.log("Worker started working ..", LogLevel.Warn);
        while (running) {
            // Mine for BTC
            //System.out.println("Working ..");
        }
        Logger.log("Worker stopper working.", LogLevel.Info);
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

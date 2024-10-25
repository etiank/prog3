package org.vaje2;

import util.LogLevel;
import util.Logger;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello");
//
//        Logger.log("Hi", LogLevel.Info);
//        Logger.log("Hi", LogLevel.Debug);
//        Logger.log("Hi", LogLevel.Warn);
//        Logger.log("Hi", LogLevel.Error);
//        Logger.log("Hi", LogLevel.Success);
//        Logger.log("Hi", LogLevel.Status);
        Logger.log("This is my message!");

        //example with extending Thread
        HelloThread myThread = new HelloThread();
        myThread.start(); // .start klice method `run`

        //example with Runnable
        Thread anotherThread = new Thread(new HelloTask());
        anotherThread.start();

        myThread.join();
        anotherThread.join();

        Logger.log("Done", LogLevel.Success); // zdej bo Done vedno zadnji

    }
}

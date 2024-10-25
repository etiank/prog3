package vaje4;
import jdk.jfr.DataAmount;
import util.LogLevel;
import util.Logger;
import java.awt.*;
import java.util.Random;

public class Example1 {

    public static final int NUM_OF_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        GUI gui = new GUI();
        Random r = new Random();
        long start = System.currentTimeMillis();
        long endTime = start + 1000;

        int totalHits = 0;
        int totalTotal = 0;

        DartThrower[] threads = new DartThrower[NUM_OF_THREADS];
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            threads[i] = new DartThrower(endTime, r, gui);
            threads[i].start();
        }

        for (DartThrower t : threads){
            t.join();
            totalHits += t.getHits();
            totalTotal += t.getTotal();
        }

        double calculatedPI = 4. * totalHits/totalTotal;
        Logger.log("Calculcated PI: " + calculatedPI, LogLevel.Success);
        Logger.log("Error: " + (calculatedPI - Math.PI), LogLevel.Error);
        Logger.log("Total: " + String.format("%,d", totalTotal), LogLevel.Info);
        gui.close();

    }

}

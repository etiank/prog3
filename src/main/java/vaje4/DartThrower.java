package vaje4;

import java.awt.*;
import java.util.Random;

public class DartThrower extends Thread {

    private long endTime;
    private Random r;
    private GUI gui;
    private int hits =0;
    private int total =0;

    public DartThrower(long endTime, Random r, GUI gui) {
        this.endTime = endTime;
        this.r = r;
        this.gui = gui;
    }

    @Override
    public void run(){

        while (System.currentTimeMillis() < endTime){
            float x = r.nextFloat(-1, 1); // bound from -1 to 1
            float y = r.nextFloat(-1, 1);
            double xSquared = Math.pow(x,2);
            double ySquared = Math.pow(y,2);
            double distFromCenter = (xSquared + ySquared);

            Color pointColor = Color.DARK_GRAY;
            if (distFromCenter <= 1){
                pointColor = Color.CYAN;
                hits++;
            }
            total++;
            //gui.drawPoint(x,y, pointColor);   // graphics is very expensive
        }

    }

    public int getTotal(){
        return total;

    }

    public int getHits(){
        return hits;
    }

}

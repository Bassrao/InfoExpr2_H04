package lego1129;

import lejos.utility.Delay;


public class TimerClass implements Runnable {
	private static int time = 0;

    @Override
    public void run() {
        while (time <= 3250) {
        	Delay.msDelay(10);
            time += 10;
        }
    }

    public static int gettime() {
        return time;
    }
}

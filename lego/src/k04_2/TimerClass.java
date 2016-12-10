package k04_2;

import lejos.utility.Delay;


public class TimerClass implements Runnable {
	private static int time = 0;

    @Override
    public void run() {
        while (time <= 10000) {
        	Delay.msDelay(100);
            time += 100;
        }
    }

    public static int gettime() {
        return time;
    }
}
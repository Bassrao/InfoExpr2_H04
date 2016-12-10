package lego1129_2;

import lejos.utility.Delay;

public class Timer1Class implements Runnable {
	private static int time = 0;

    @Override
    public void run() {
        while (time <= 5000) {
        	Delay.msDelay(10);
            time += 10;
        }
    }

    public static int gettime() {
        return time;
    }
}
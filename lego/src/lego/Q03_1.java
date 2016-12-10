package lego;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Q03_1 {

	public static class SoundClass implements Runnable {

        private int timer = 0;

        @Override
        public void run() {
            while (timer <= 5000) {
                Sound.playTone(100, 100);
                Delay.msDelay(100);
                timer += 100;
            }
        }
    }

	public static class RunClass implements Runnable {

	    private int 時間 = 0;
	    private static RegulatedMotor 左モーター = Motor.C;
        private static RegulatedMotor 右モーター = Motor.B;

	    @Override
	    public void run() {
	        while (時間 <= 5000) {
	        	左モーター.forward();     // 前進
	            右モーター.forward();     // 前進
	            Delay.msDelay(100);
	            時間 += 100;
	        }
	    }
	}

	public static void main(String[] args) {
        Thread soundThread = new Thread(new SoundClass());
        Thread runThread   = new Thread(new RunClass());

        soundThread.start();
        runThread.start();

        try {
        	soundThread.join();
            runThread.join();
        } catch (InterruptedException e) {
            //例外処理();
        }
    }

}

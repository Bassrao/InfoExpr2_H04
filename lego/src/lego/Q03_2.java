package lego;

import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Q03_2 {

	public final static TouchSensor touch = new TouchSensor(SensorPort.S1);

	public static class SoundClass implements Runnable {

        @Override
        public void run() {
            while (! Q03_2.touch.isPressed()) {
                Sound.playTone(100, 100);
                Delay.msDelay(100);
            }
        }
    }

	public static class RunClass implements Runnable {

	    private static RegulatedMotor 左モーター = Motor.C;
        private static RegulatedMotor 右モーター = Motor.B;

	    @Override
	    public void run() {
	        while (! Q03_2.touch.isPressed()) {
	        	左モーター.forward();     // 前進
	            右モーター.forward();     // 前進
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

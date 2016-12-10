package lego;

import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Q04_1 {

	public class SenClass implements Runnable {

		private static TouchSensor touch = new TouchSensor(SensorPort.S1);
		public static Boolean status = true;

        @Override
        public void run() {
        	while (TimerClass.gettime() <= 10000) {
        		Toguru();
            }
        }

        public void Toguru() {
            if (this.touch.isPressed()) {
                status = ! status;
                Delay.msDelay(500);
            }
        }
    }

	public static class RunClass implements Runnable {

	    private static RegulatedMotor 左モーター = Motor.C;
        private static RegulatedMotor 右モーター = Motor.B;

	    @Override
	    public void run() {
	        while (TimerClass.gettime() <= 10000) {
	        	if (SenClass.status == true) {
		        	左モーター.forward();     // 前進
		            右モーター.forward();     // 前進
	        	} else {
	        		左モーター.backward();
	            	右モーター.backward();
	        	}
	        }
	    }
	}

	public static class TimerClass implements Runnable {
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

	public static void main(String[] args) {

        Thread senThread = new Thread(new SenClass());
        Thread timeThread = new Thread(new TimerClass());
        Thread runThread   = new Thread(new RunClass());

        senThread.start();
        timeThread.start();
        runThread.start();

        try {
        	senThread.join();
            timeThread.join();
            runThread.join();
        } catch (InterruptedException e) {
            //例外処理();
        }
    }

}

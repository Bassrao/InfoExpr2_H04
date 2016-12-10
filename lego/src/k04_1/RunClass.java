package k04_1;

import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class RunClass implements Runnable {

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
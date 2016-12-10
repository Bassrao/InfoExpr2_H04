package k04_2;

import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class RunClass implements Runnable {

    private static RegulatedMotor 左モーター = Motor.C;
    private static RegulatedMotor 右モーター = Motor.B;

    @Override
    public void run() {
        while (TimerClass.gettime() <= 10000) {
        	switch (StatusClass.getstatus()) {
            case forward:
            	左モーター.forward();     // 前進
	            右モーター.forward();     // 前進
                break;
            case left:
            	左モーター.backward();
            	右モーター.forward();
                break;
            case right:
            	左モーター.forward();
            	右モーター.backward();
                break;
            case stop:
            	右モーター.stop(true);
            	左モーター.stop();
                break;
            }
        	Delay.msDelay(10);
        }
    }
}
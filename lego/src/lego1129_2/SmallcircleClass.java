package lego1129_2;

import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class SmallcircleClass  implements Runnable {
	  private static RegulatedMotor lMoter = Motor.C;
	    private static RegulatedMotor rMoter = Motor.B;

	    @Override
	    public void run() {

	    	rMoter.setSpeed(700);
			lMoter.setSpeed(500);

	        while (Timer2Class.gettime() <= 3100) {
				rMoter.forward();
				lMoter.forward();
	        }

	        rMoter.stop(true);
	        lMoter.stop();

	    }
}

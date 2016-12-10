package lego1129_2;

import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class BigcircleClass implements Runnable {

    private static RegulatedMotor lMoter = Motor.C;
    private static RegulatedMotor rMoter = Motor.B;

    @Override
    public void run() {

    	rMoter.setSpeed(700);
		lMoter.setSpeed(520);

        while (Timer1Class.gettime() <= 3800) {
			rMoter.forward();
			lMoter.forward();
        }

        rMoter.setSpeed(300);
		lMoter.setSpeed(300);


        while (Timer1Class.gettime() <= 5000) {
        	lMoter.forward();
			rMoter.backward();
		}

        rMoter.stop(true);
        lMoter.stop();

    }
}
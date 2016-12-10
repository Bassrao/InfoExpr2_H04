// 黒線追跡
// H04

package lineTrace;

import jp.ac.kagawa_u.infoexpr.Sensor.ColorSensor;
import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;


public class DoubleLineTrace implements Runnable {

	static TouchSensor touch = new TouchSensor(SensorPort.S1);
	ColorSensor rightLight;
	ColorSensor leftLight;
	static RegulatedMotor rightMotor  = Motor.B;
	static RegulatedMotor leftMotor  = Motor.C;

	DoubleLineTrace (ColorSensor right, ColorSensor left) {
		rightLight = right;
		leftLight = left;
	}

	@Override
	public void run() {

		float middleValue = 0.40F;
		int lowSpeed = 220;
		int highSpeed = 500;

		while ( ! touch.isPressed() ){
			// 黒＆黒
			if( leftLight.getRed() < middleValue && rightLight.getLight() < middleValue ) { }

			// 黒＆白
			else if ( leftLight.getLight() < middleValue && rightLight.getLight() >= middleValue ) {
				motorSetSpeed(lowSpeed, highSpeed);
				motorForward();
			}

			// 白＆黒
			else if ( leftLight.getLight() >= middleValue && rightLight.getLight() < middleValue ) {
				motorSetSpeed(highSpeed, lowSpeed);
				motorForward();
			}

			// 白＆白
			else if ( leftLight.getLight() >= middleValue && rightLight.getLight() >= middleValue ) {
				motorSetSpeed(highSpeed, highSpeed);
				motorForward();
			}
		}
	}


	private static void motorSetSpeed(int leftMotorSpeed, int rightMotorSpeed){
		leftMotor.setSpeed(leftMotorSpeed);
		rightMotor.setSpeed(rightMotorSpeed);
	}

	private static void motorForward(){
		leftMotor.forward();
		rightMotor.forward();
	}
}

// 領域掃出

package lego1213;

import jp.ac.kagawa_u.infoexpr.Sensor.ColorSensor;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Clean{
	static ColorSensor rightLight = new ColorSensor(SensorPort.S2);
	static ColorSensor leftLight = new ColorSensor(SensorPort.S3);
	static RegulatedMotor rightMotor = Motor.B;
	static RegulatedMotor leftMotor  = Motor.C;

	public static void main(String[] args) {

		float middleValue = 0.40F;
		int Speed = 700;
		int ang1 = 80;
		int ang2 = 170;

		motorSetSpeed(Speed, Speed);
		motorForward();
		Delay.msDelay(300);

		while ( ! Button.ESCAPE.isDown() ){
			motorSetSpeed(Speed, Speed);
			// 黒＆黒
			if( leftLight.getLight() < middleValue && rightLight.getLight() < middleValue ) {
				motorBackward();
				motorTurn(ang2, 3);
				motorForward();
			}
			// 黒＆白
			else if ( leftLight.getLight() < middleValue && rightLight.getLight() >= middleValue ) {
				motorBackward();
				motorTurn(ang1, 1);
				motorForward();
			}
			// 白＆黒
			else if ( leftLight.getLight() >= middleValue && rightLight.getLight() < middleValue ) {
				motorBackward();
				motorTurn(ang1, 2);
				motorForward();
			}
			// 白＆白
			else if ( leftLight.getLight() >= middleValue && rightLight.getLight() >= middleValue ) {
				motorForward();
			} else {
				motorForward();
			}
		}
	}


	private static void motorSetSpeed(int leftMotorSpeed, int rightMotorSpeed) {
		leftMotor.setSpeed(leftMotorSpeed);
		rightMotor.setSpeed(rightMotorSpeed);
	}

	private static void motorForward() {
		leftMotor.forward();
		rightMotor.forward();
	}

	private static void motorBackward() {
		leftMotor.backward();
		rightMotor.backward();
		Delay.msDelay(200);     // 0.2秒停止
		rightMotor.stop(true);
		leftMotor.stop();
	}

	// 回転
	// direction 1:右 2:左 3:
	private static void motorTurn(int angle, int direction) {
		int k = 3;
		if ( direction == 1 ) {
			leftMotor.forward();
			rightMotor.backward();
			Delay.msDelay(angle * k);
		} else if ( direction == 2 ) {
			leftMotor.backward();
			rightMotor.forward();
			Delay.msDelay(angle * k);
		} else {
			leftMotor.backward();
			rightMotor.forward();
			Delay.msDelay(angle * k);
		}
		rightMotor.stop(true);
		leftMotor.stop();
	}

}

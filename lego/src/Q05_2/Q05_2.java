package Q05_2;

import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;

public class Q05_2 {
	static TouchSensor touch = new TouchSensor(SensorPort.S1);
    private static RegulatedMotor 左モーター = Motor.C;
    private static RegulatedMotor 右モーター = Motor.B;

    public static void main(String[] args) {
    	左モーター.resetTachoCount();                  // モーターの回転数のリセット
    	右モーター.resetTachoCount();                  // モーターの回転数のリセット

    	左モーター.setSpeed(100);
    	右モーター.setSpeed(100);
    	while (!  touch.isPressed()) {
    		左モーター.forward();     // 前進
            右モーター.forward();     // 前進
        } while (左モーター.getTachoCount() > 0) {
        	左モーター.backward();
        	右モーター.backward();
        	左モーター.getTachoCount();
        	右モーター.getTachoCount();
        }
    }
}
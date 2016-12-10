package Q05_1;

import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;

public class Q05_1 {
	private static int time = 0;
	static TouchSensor touch = new TouchSensor(SensorPort.S1);
    private static RegulatedMotor 左モーター = Motor.C;
    private static RegulatedMotor 右モーター = Motor.B;

    public static void main(String[] args) {
        while (!  touch.isPressed()) {
        	左モーター.forward();     // 前進
            右モーター.forward();     // 前進
            time++;
        } while (time >= 0) {
        	左モーター.backward();
        	右モーター.backward();
            time--;
        }
    }
}
package lego;
import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Q01_3 {
	private static TouchSensor touch = new TouchSensor(SensorPort.S1);
    private static RegulatedMotor 左モーター = Motor.C;
    private static RegulatedMotor 右モーター = Motor.B;
    private static int 時間 = 0;

    public static void main(String[] args) {
        while (! touch.isPressed()) {
        	左モーター.forward();     // 前進
            右モーター.forward();     // 前進
        }
        while ( 時間 <= 1000) {
        	左モーター.backward();
        	右モーター.backward();
        	Delay.msDelay(1);
        	時間 += 1;
        }
    }
}

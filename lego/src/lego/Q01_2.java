package lego;

import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;

public class Q01_2 {
	private static TouchSensor touch = new TouchSensor(SensorPort.S1);

    public static void main(String[] args) {
        while (! touch.isPressed() ) {
        	Sound.playTone(880, 1000);
        }
    }
}

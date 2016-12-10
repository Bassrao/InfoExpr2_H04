package k04_1;

import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class SenClass implements Runnable {

	private static TouchSensor touch = new TouchSensor(SensorPort.S1);
	public static Boolean status = true;

    @Override
    public void run() {
    	while (TimerClass.gettime() <= 10000) {
    		Toguru();
        }
    }

    public void Toguru() {
        if (touch.isPressed()) {
            status = ! status;
            Delay.msDelay(500);
        }
    }
}

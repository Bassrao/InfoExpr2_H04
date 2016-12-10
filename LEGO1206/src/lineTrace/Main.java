package lineTrace;

import jp.ac.kagawa_u.infoexpr.Sensor.ColorSensor;
import lejos.hardware.port.SensorPort;



public class Main {
	static ColorSensor rightLight = new ColorSensor(SensorPort.S2);
    static ColorSensor leftLight = new ColorSensor(SensorPort.S3);

	public static void main(String[] args) {

        Thread DoubleLineTrace = new Thread(new DoubleLineTrace(rightLight, leftLight));
        Thread SoundThread = new Thread(new SoundClass(leftLight));

        DoubleLineTrace.start();
        SoundThread.start();

        try {
        	DoubleLineTrace.join();
        	SoundThread.join();
        } catch (InterruptedException e) {
            //例外処理();
        }
    }
}

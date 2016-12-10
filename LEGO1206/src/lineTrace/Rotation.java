package lineTrace;

import jp.ac.kagawa_u.infoexpr.Sensor.ColorSensor;
import lejos.hardware.Button;

public class Rotation implements Runnable {
	ColorSensor colorLight;

	@Override
    public void run() {
		double colorRed = 0.240;
		double colorGreenlow = 0.10;
		if ( colorLight.getRed() >= colorRed && colorLight.getGreen() <= colorGreenlow ) {
            Button.LEDPattern(2); // 赤色に点灯
        }
	}
}

package lineTrace;

import jp.ac.kagawa_u.infoexpr.Sensor.ColorSensor;
import lejos.hardware.Sound;
import lejos.utility.Delay;

public class SoundClass implements Runnable {

	ColorSensor colorLight;


	double wid = 0.1;    //
	double GreenR = 0.086 + wid / 2;
	double GreenG =0.241 + wid / 2;

	int count = 0;
	int panel = 3;      // パネルの数

	int delaytime = 50;

	SoundClass (ColorSensor left) {
		colorLight = left;
	}

	@Override
	public void run() {
		while ( count < panel) {
			if ( colorLight.getRed() >= GreenR - wid && colorLight.getRed() <= GreenR
					&& colorLight.getGreen() >= GreenG - wid && colorLight.getGreen() <= GreenG ) {
				Sound.beep();
				Delay.msDelay(delaytime);
				count++;
			}
		}
	}
}

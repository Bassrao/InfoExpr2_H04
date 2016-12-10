package lego;
import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;

public class Q02_1 {
	 static TouchSensor touch = new TouchSensor(SensorPort.S1);
	    public static void main(String[] args) {
	        while(! (Button.ESCAPE.isDown()&&touch.isPressed()) ) {
	            while( touch.isPressed() ){
	            	Sound.playTone(880, 1000);
	            }
	        }
	    }
}

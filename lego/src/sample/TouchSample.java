
package sample;
import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;

public class TouchSample {

    static TouchSensor touch = new TouchSensor(SensorPort.S1);
    static boolean state;

    public static void main(String[] args) {
        while( ! Button.ESCAPE.isDown() ) {
            LCD.clear();
            state = touch.isPressed();
            LCD.drawString(String.valueOf(state), 1, 1);
            LCD.refresh();
        }
        LCD.clear();
        LCD.refresh();
    }
}
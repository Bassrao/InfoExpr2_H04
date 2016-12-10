package lego;

import jp.ac.kagawa_u.infoexpr.Sensor.TouchSensor;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;

public class Q02_4 {
	static TouchSensor touch = new TouchSensor(SensorPort.S1);
    private static RegulatedMotor 左モーター = Motor.C;
    private static RegulatedMotor 右モーター = Motor.B;

    public static void main(String[] args) {
    	左モーター.setSpeed(200);
    	右モーター.setSpeed(200);
        while( !Button.ESCAPE.isDown() ) {
        	while( ! touch.isPressed() ){}
        	while( touch.isPressed() ){}
        	左モーター.forward();     // 前進
            右モーター.forward();     // 前進
            while( ! touch.isPressed() ){}
        	while( touch.isPressed() ){}
        	左モーター.backward();
        	右モーター.backward();
        }
        右モーター.stop(true);
        左モーター.stop();
    }
}
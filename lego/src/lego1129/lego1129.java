package lego1129;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Stopwatch;

public class lego1129 {
	static RegulatedMotor rMoter  = Motor.B;
	static RegulatedMotor lMoter  = Motor.C;
	boolean enterState = Button.ENTER.isDown();
	private static Stopwatch stopwatch = new Stopwatch();

	int value = 0;

	public void main(String[] args) {
		/*while (! Button.ESCAPE.isDown()) {
			rMoter.setSpeed(700);
			lMoter.setSpeed(520);

			rMoter.forward();
			lMoter.forward();
		}*/
		while (value <= 3.25) {
		value = stopwatch.elapsed();
		rMoter.setSpeed(700);
		lMoter.setSpeed(520);

		rMoter.forward();
		lMoter.forward();
		}



	}
}

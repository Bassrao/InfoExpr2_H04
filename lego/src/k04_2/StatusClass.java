package k04_2;

import lejos.hardware.Button;

public class StatusClass implements Runnable {

	private static status st = status.stop;

    @Override
    public void run() {
    	while (TimerClass.gettime() <= 10000) {
    		Renew();
        }
    }

    public void Renew() {
    	if (Button.ENTER.isDown()) {
            st = status.forward;
        } else if (Button.RIGHT.isDown()){
            st = status.right;
        } else if (Button.LEFT.isDown()) {
            st = status.left;
        } else if (Button.ESCAPE.isDown()) {
            st = status.stop;
        }
    }

    public static status getstatus() {
        return st;
    }
}

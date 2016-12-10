package k04_1;


public class Main {
	public static void main(String[] args) {

        Thread senThread = new Thread(new SenClass());
        Thread timeThread = new Thread(new TimerClass());
        Thread runThread   = new Thread(new RunClass());

        senThread.start();
        timeThread.start();
        runThread.start();

        try {
        	senThread.join();
            timeThread.join();
            runThread.join();
        } catch (InterruptedException e) {
            //例外処理();
        }
    }

}

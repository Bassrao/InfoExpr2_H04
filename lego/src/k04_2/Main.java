package k04_2;


public class Main {
	public static void main(String[] args) {

        Thread statusThread = new Thread(new StatusClass());
        Thread timeThread = new Thread(new TimerClass());
        Thread runThread   = new Thread(new RunClass());

        statusThread.start();
        runThread.start();
        timeThread.start();

        try {
        	statusThread.join();
            timeThread.join();
            runThread.join();
        } catch (InterruptedException e) {
            //例外処理();
        }
    }

}

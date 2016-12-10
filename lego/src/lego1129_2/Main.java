package lego1129_2;


public class Main {
	public static void main(String[] args) {

        Thread time1Thread = new Thread(new Timer1Class());
        Thread time2Thread = new Thread(new Timer2Class());
        Thread BigcircleThread   = new Thread(new BigcircleClass());
        Thread SmallcircleThread = new Thread(new SmallcircleClass());

        BigcircleThread.start();
        time1Thread.start();

        try {
            time1Thread.join();
            BigcircleThread.join();
        } catch (InterruptedException e) {
            //例外処理();
        }

        SmallcircleThread.start();
        time2Thread.start();

        try {
        	time2Thread.join();
        	SmallcircleThread.join();
        } catch (InterruptedException e) {
            //例外処理();
        }
    }

}

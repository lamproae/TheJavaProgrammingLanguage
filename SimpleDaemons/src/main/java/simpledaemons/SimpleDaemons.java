package simpledaemons;

import java.util.concurrent.*;

public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

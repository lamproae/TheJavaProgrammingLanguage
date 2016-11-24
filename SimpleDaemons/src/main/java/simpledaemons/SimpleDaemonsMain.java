package simpledaemons;

import java.util.concurrent.*;

public class SimpleDaemonsMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }

        System.out.println("All daemon stated");
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

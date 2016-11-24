package daemonthreadfactory;

import java.util.concurrent.*;

public class DaemonThreadFactoryMain  implements Runnable {
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

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++)
            exec.execute(new DaemonThreadFactoryMain());

        System.out.println("All daemons started !");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}

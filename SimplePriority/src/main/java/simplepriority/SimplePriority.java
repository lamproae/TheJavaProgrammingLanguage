package simplepriority;

import java.util.concurrent.*;

public class SimplePriority implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    public String toString()  {
        return Thread.currentThread() + ": " + countDown;
    }

    public void run () {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI / Math.E + Math.E * Math.PI) * Math.PI / ((double)i * Math.E);
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) 
                return;
        }
    }
}

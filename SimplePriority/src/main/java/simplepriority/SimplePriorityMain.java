package simplepriority;

import java.util.concurrent.*;

public class SimplePriorityMain {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SimplePriority(Thread.MIN_PRIORITY));
        exec.execute(new SimplePriority(Thread.MAX_PRIORITY));

        exec.shutdown();
    }
}

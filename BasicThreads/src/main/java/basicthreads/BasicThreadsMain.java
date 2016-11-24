package basicthreads;

import java.util.concurrent.*;

public class BasicThreadsMain {
    public static void main(String[] args) {
        BasicThreads launch = new BasicThreads();
        launch.run();

        System.out.print("Waiting for LiftOff!");
        Thread t = new Thread(new BasicThreads());
        t.start();
        System.out.print("Waiting for LiftOff!");

        for (int i = 0; i < 5; i++) {
            new Thread(new BasicThreads()).start();
            System.out.print("Waiting for LiftOff!");
        }

        System.out.print("Waiting for LiftOff!");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new BasicThreads());
        }
        exec.shutdown();

        System.out.print("Waiting for LiftOff!");
        ExecutorService fixedExec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            fixedExec.execute(new BasicThreads());
        }
        fixedExec.shutdown();

        System.out.print("Waiting for LiftOff!");
        ExecutorService singleExec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            singleExec.execute(new BasicThreads());
        singleExec.shutdown();
    }
}

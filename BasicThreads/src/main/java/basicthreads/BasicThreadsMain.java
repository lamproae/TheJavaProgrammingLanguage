package basicthreads;

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
    }
}

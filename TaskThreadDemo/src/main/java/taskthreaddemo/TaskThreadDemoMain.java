package taskthreaddemo;

public class TaskThreadDemoMain {
    public static void main(String[] args) {
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);
        Runnable printC = new PrintChar('c', 100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        Thread thread4 = new Thread(printC);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}


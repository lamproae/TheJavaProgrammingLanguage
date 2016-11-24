package callabledemo;

import java.util.concurrent.*;
import java.util.*;

public class CallableDemoMain {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new CallableDemo(i)));

        for (Future<String> fs : results)
            try {
                System.out.println(fs.get());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                return;
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            } finally {
                exec.shutdown();
            }
    }
}

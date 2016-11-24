package callabledemo;

import java.util.concurrent.*;
import java.util.*;

public class CallableDemo implements Callable<String> {
    private int id;
    public CallableDemo(int id) {
        this.id = id;
    }

    public String call() {
        return "Result of CallableDemo " + id;
    }
}

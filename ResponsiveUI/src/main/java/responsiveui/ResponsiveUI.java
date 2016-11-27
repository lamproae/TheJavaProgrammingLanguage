package responsiveui;

class UnresponsiveUI {
    volatile double d = 1;
    public UnresponsiveUI() throws Exception {
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read();
    }
}

public class ResponsiveUI extends Thread {
    static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }
}

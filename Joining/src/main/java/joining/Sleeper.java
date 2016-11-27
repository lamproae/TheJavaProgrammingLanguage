package joining;

class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(getName() + " has awakened");
    }
}


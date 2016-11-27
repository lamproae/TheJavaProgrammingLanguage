package joining;

public class JoiningMain {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("sleepy", 1500);
        Sleeper grumpy = new Sleeper("grumpy", 1500);

        Joiner dopey = new Joiner("dopey", sleepy);
        Joiner docey = new Joiner("docey", grumpy);

        grumpy.interrupt();
    }
}

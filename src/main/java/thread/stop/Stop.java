package thread.stop;

public class Stop {
    public static void main(String[] args) {
        RunnableWithDoStop runnableWithDoStop = new RunnableWithDoStop();

        Thread thread = new Thread(runnableWithDoStop);

        thread.start();

        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runnableWithDoStop.doStop();
    }
}

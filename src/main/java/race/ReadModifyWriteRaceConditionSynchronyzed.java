package race;

public class ReadModifyWriteRaceConditionSynchronyzed {
    public static void main(String[] args) {
        new Thread(
                () -> {
                    for (int i = 0; i < 100000; i++) {
                        Counter.increment(1);
                    }},
                 "First"
        ).start();
        new Thread(
                () -> {
                    for (int i = 0; i < 100000; i++) {
                        Counter.increment(1);
                    }},
                "Second"
        ).start();
    }

    private static class Counter {
        protected static long count = 0;

        //critical section
        synchronized public static void increment(long value) {
            count = count + value;
            System.out.println(Thread.currentThread().getName() + " " + count);
        }
    }
}

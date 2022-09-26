package race;

import java.util.concurrent.atomic.AtomicLong;

public class ReadModifyWriteRaceConditionAtomicLong {
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
        protected static AtomicLong count = new AtomicLong(0);

        //critical section
        public static void increment(long value) {
            count.addAndGet(value);
            System.out.println(Thread.currentThread().getName() + " " + count);
        }
    }
}

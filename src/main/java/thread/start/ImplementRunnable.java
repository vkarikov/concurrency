package thread.start;

public class ImplementRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new AnotherOneThread(), "Runnable");
        thread.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread threadTwo = new Thread(runnable, "Anonymous");
        threadTwo.start();

        Runnable runnableTwo = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread threadThree = new Thread(runnableTwo, "Lambda");
        threadThree.start();

    }

    private static class AnotherOneThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

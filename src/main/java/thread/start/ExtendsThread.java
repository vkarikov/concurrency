package thread.start;

public class ExtendsThread {
    public static void main(String[] args) {

        AnotherOneThread thread = new AnotherOneThread();
        thread.start();

        Thread threadTwo = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        threadTwo.start();
    }

    private static class AnotherOneThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

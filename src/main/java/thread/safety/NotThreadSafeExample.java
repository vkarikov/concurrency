package thread.safety;

public class NotThreadSafeExample {
    public static void main(String[] args) {
        notSafe();
        safe();
    }

    private static void notSafe() {
        NotThreadSafe sharedInstance = new NotThreadSafe();
        new Thread(new MyRunnable(sharedInstance)).start();
        new Thread(new MyRunnable(sharedInstance)).start();
    }

    private static void safe() {
        new Thread(new MyRunnable(new NotThreadSafe())).start();
        new Thread(new MyRunnable(new NotThreadSafe())).start();
    }
    private static class MyRunnable implements Runnable{
        NotThreadSafe instance = null;

        public MyRunnable(NotThreadSafe instance){
            this.instance = instance;
        }

        public void run(){
            this.instance.add("some text");
        }
    }
}

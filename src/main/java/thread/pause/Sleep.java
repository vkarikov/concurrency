package thread.pause;

public class Sleep {
    public static void main(String[] args) {
        new Thread(
                () -> {
                    try {
                        System.out.print("Sleeping...");
                        for (int i = 0; i < 10; i++) {
                            Thread.sleep(1000);
                            System.out.print(".");
                        }
                        System.out.println();
                        System.out.println("Wake up.");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();
    }
}

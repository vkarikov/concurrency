package race;

import java.util.HashMap;
import java.util.Map;

public class CheckThanActRaceConditionSynchronized {
    public static void main(String[] args) {
        Map<String, String> sharedMap = new HashMap<>();
        sharedMap.put("key", "value");
        new Thread(
                () -> {
                    for (int i = 0; i < 10000; i++) {
                        Checked.checkThenAct(sharedMap);
                    }},
                 "First"
        ).start();
        new Thread(
                () -> {
                    for (int i = 0; i < 10000; i++) {
                        Checked.checkThenAct(sharedMap);
                    }},
                "Second"
        ).start();
    }

    private static class Checked {
        synchronized public static void checkThenAct(Map<String, String> sharedMap) {
            if(sharedMap.containsKey("key")){
                String val = sharedMap.remove("key");
                if(val == null) {
                    System.out.println("Value for 'key' was null");
                }
            } else {
                sharedMap.put("key", "value");
            }
        }
    }
}

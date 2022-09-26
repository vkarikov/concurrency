package race;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CheckThanActRaceConditionConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentMap<String, String> sharedMap = new ConcurrentHashMap<>();
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
        public static void checkThenAct(ConcurrentMap<String, String> sharedMap) {
            sharedMap.putIfAbsent("key", "value");
        }
    }
}

import java.util.HashMap;
import java.util.Map;

public class PG42556 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = new HashMap<>();
        String answer = "";

        for (int i = 0; i < completion.length; i++) {
            if (completionMap.containsKey(completion[i])) {
                int value = completionMap.get(completion[i]);
                completionMap.put(completion[i], value + 1);
            } else {
                completionMap.put(completion[i], 1);
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if (completionMap.containsKey(participant[i])) {
                int value = completionMap.get(participant[i]);
                if (value > 1) {
                    completionMap.put(participant[i], value - 1);
                } else {
                    completionMap.remove(participant[i]);
                }
            } else {
                return answer = participant[i];
            }
        }

        return answer;
    }

}

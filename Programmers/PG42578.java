import java.util.*;

public class PG42578 {

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int dp[] = new int[map.size() + 1];
        int i = 0;
        for (String key : map.keySet()) {
            int value = map.get(key);
            dp[i + 1] = dp[i] + (dp[i] + 1) * value;
            i++;
        }

        answer = dp[i];
        return answer;
    }

}

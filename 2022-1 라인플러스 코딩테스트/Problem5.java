import java.util.*;
import java.util.stream.Collectors;

public class Problem5 {

    public long solution(int[] abilities, int k) {
        List<Integer> list = Arrays.stream(abilities).boxed().collect(Collectors.toList());
        if (abilities.length % 2 != 0) {
            list.add(0);
        }

        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

        int[] final_abilities = list.stream().mapToInt(i -> i).toArray();
        Integer[] interval = new Integer[final_abilities.length / 2];
        Integer[] sorted_interval = new Integer[final_abilities.length / 2];
        for (int i = 0; i < sorted_interval.length; i++) {
            interval[i] = final_abilities[2 * i] - final_abilities[2 * i + 1];
            sorted_interval[i] = final_abilities[2 * i] - final_abilities[2 * i + 1];
        }

        Arrays.sort(sorted_interval, Collections.reverseOrder()); // 내림차순 정렬

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(sorted_interval[i], map.getOrDefault(sorted_interval[i], 0) + 1);
        }

        long answer = 0;
        for (int i = 0; i < interval.length; i++) {
            if (map.containsKey(interval[i]) && map.get(interval[i]) > 0) {
                map.put(interval[i], map.get(interval[i]) - 1);
                answer += final_abilities[2 * i];
            } else {
                answer += final_abilities[2 * i + 1];
            }
        }
        return answer;
    }

}

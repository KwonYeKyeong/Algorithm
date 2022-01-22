import java.util.*;

public class PG92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> idMap = new HashMap<>(id_list.length); // 인덱스값(value)으로 유저(key)를 접근하기 위한 map
        Map<String, Integer> reportCount = new HashMap<>(id_list.length); // 유저별로 신고당한 횟수를 기록하는 map
        Map<String, List<String>> reportList = new HashMap<>(id_list.length); // 신고한 사람들(value)을 신고당한 사람(key)별로 저장한 map
        Set<String> reportSet = new HashSet<>(); // 중복된 신고를 제거하기 위한 set
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
        }

        Arrays.stream(report).forEach(r -> reportSet.add(r));

        for (String r : reportSet) {
            String[] users = r.split(" ");

            reportCount.put(users[1], reportCount.getOrDefault(users[1], 0) + 1);

            if (!reportList.containsKey(users[1])) {
                reportList.put(users[1], new ArrayList<>());
            }
            List<String> valueList = reportList.get(users[1]);
            valueList.add(users[0]);
        }

        for (Map.Entry<String, Integer> entry : reportCount.entrySet()) {
            if (entry.getValue() >= k) {
                List<String> valueList = reportList.get(entry.getKey());
                for (String user : valueList) {
                    answer[idMap.get(user)]++;
                }
            }
        }

        return answer;
    }

}
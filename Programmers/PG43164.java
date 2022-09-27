import java.util.*;

public class PG43164 {

    public static final String START = "ICN";

    public Map<String, List<String>> map;
    public int total;
    public List<String> answer;

    public String[] solution(String[][] tickets) {
        total = tickets.length;
        map = new HashMap<>();
        for (String[] ticket : tickets) {
            String a = ticket[0];
            String b = ticket[1];

            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
        }

        Map<String, Boolean[]> visited = new HashMap<>();
        for (String key : map.keySet()) {
            map.get(key).sort(Comparator.naturalOrder()); // 알파벳 순서가 앞서는 경로 순 = 오름차순
            Boolean[] visitedArray = new Boolean[map.get(key).size()];
            Arrays.fill(visitedArray, false);
            visited.put(key, visitedArray);
        }

        answer = new ArrayList<>();
        List<String> route = new ArrayList<>();
        route.add(START);
        dfs(visited, route, START);

        return answer.toArray(String[]::new);
    }

    public void dfs(Map<String, Boolean[]> visited, List<String> route, String a) {
        if (route.size() == (total + 1) && answer.isEmpty()) {
            answer = new ArrayList<>(route);
            return;
        }
        if (!map.containsKey(a)) {
            return;
        }

        for (int i = 0; i < map.get(a).size(); i++) {
            if (visited.get(a)[i]) {
                continue;
            }

            String b = map.get(a).get(i);

            visited.get(a)[i] = true;
            ;
            route.add(b);
            dfs(visited, route, b);
            visited.get(a)[i] = false;
            route.remove(route.size() - 1);
        }
    }

}

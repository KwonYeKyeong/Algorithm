import java.util.*;

public class PG64064 {

    Set<String> set; // 중복된 경우의 수를 제거하기 위해 HashSet 사용
    String[] users;
    boolean[] visited;
    String[] patterns;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        users = user_id;
        visited = new boolean[user_id.length];
        patterns = Arrays.stream(banned_id).map(id -> id.replace("*", ".")).toArray(String[]::new); // 정규표현식을 사용하기 위해 * -> .

        dfs(0, new ArrayList<Integer>());

        return set.size();
    }

    public void dfs(int idx, List<Integer> idxList) {
        if (idxList.size() == patterns.length) {
            Collections.sort(idxList);
            StringBuilder sb = new StringBuilder();
            idxList.stream().forEach(i -> sb.append(i));
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < users.length; i++) {
            if (visited[i] == false && users[i].matches(patterns[idx])) {
                visited[i] = true;
                idxList.add(i);
                dfs(idx + 1, idxList);
                visited[i] = false;
                idxList.remove(Integer.valueOf(i));
            }
        }
    }

}
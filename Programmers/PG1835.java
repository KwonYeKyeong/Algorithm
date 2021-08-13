public class PG1835 {
    final String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" };
    int answer = 0;

    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];
        StringBuilder sb = new StringBuilder();

        dfs(sb, visited, data);

        return answer;
    }

    public void dfs(StringBuilder sb, boolean[] visited, String[] data) {
        if (sb.length() == 8) {
            if (check(sb.toString(), data))
                answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(friends[i]);
                dfs(sb, visited, data);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public boolean check(String s, String[] data) {
        for (String d : data) {
            int pos1 = s.indexOf(d.charAt(0));
            int pos2 = s.indexOf(d.charAt(2));
            char oper = d.charAt(3);
            int num = Integer.parseInt(String.valueOf(d.charAt(4)));
            if (oper == '=') {
                if (num != Math.abs(pos1 - pos2) - 1)
                    return false;
            } else if (oper == '<') {
                if (num <= Math.abs(pos1 - pos2) - 1)
                    return false;
            } else if (oper == '>') {
                if (num >= Math.abs(pos1 - pos2) - 1)
                    return false;
            }
        }
        return true;
    }
}
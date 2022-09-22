public class PG87946 {

    public int answer;

    public int solution(int k, int[][] dungeons) {
        answer = Integer.MIN_VALUE;

        explore(dungeons, new boolean[dungeons.length], k, 0);

        return answer;
    }

    public void explore(int[][] dungeons, boolean[] visited, int k, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                explore(dungeons, visited, k - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, cnt);
    }

}
public class PG42898 {

    public static final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        map[1][1] = 1; // 집
        for (int[] puddle : puddles) { // 물웅덩이
            map[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                if (map[i - 1][j] > 0) {
                    map[i][j] += map[i - 1][j] % MOD;
                }
                if (map[i][j - 1] > 0) {
                    map[i][j] += map[i][j - 1] % MOD;
                }
            }
        }

        int answer = map[n][m] % MOD;
        return answer;
    }

}

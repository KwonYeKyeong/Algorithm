class PG43105 {
    public int solution(int[][] triangle) {
        int dp[][] = new int[triangle.length][triangle.length];
        int answer = 0;

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            if (answer < dp[triangle.length - 1][i])
                answer = dp[triangle.length - 1][i];
        }

        return answer;
    }
}

import java.io.*;

public class BOJ1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[30][30];

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= m; j++) {
                    if (i == 1) {
                        dp[i][j] = i * j;
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
            }

            System.out.println(dp[n][m]);
        }
    }

}

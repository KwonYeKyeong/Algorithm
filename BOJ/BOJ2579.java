import java.io.*;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] point = new int[n];
        for (int i = 0; i < n; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        dp[0] = point[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[1] = dp[0] + point[1];
            } else if (i == 2) {
                dp[2] = Math.max(point[0], point[1]) + point[2];
            } else {
                dp[i] = Math.max(dp[i - 3] + point[i - 1], dp[i - 2]) + point[i];
            }
        }

        System.out.println(dp[n - 1]);
    }

}
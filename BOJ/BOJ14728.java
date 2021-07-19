import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] test = new int[n+1][2];
        int[][] dp = new int[n+1][t+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            test[i][0] = Integer.parseInt(st.nextToken()); // 예상 공부 시간
            test[i][1] = Integer.parseInt(st.nextToken()); // 문제의 배점
        }

        for(int i=1;i<=n;i++){
            int time = test[i][0];
            int score = test[i][1];
            for(int j=1;j<=t;j++){
                if(j-time>=0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time]+score);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.print(dp[n][t]);
    }
}

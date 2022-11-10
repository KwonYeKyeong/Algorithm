import java.io.*;

public class BOJ12852 {

    public static final int INF = 987654321;

    public static class History {
        int cnt;
        int preIdx;

        History() {
            this(INF, -1);
        }

        History(int cnt, int preIdx) {
            this.cnt = cnt;
            this.preIdx = preIdx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        History[] dp = new History[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new History();
        }

        dp[1] = new History(0, 0);
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0) {
                dp[i].cnt = dp[i / 3].cnt + 1;
                dp[i].preIdx = i / 3;
            }
            if (i % 2 == 0) {
                dp[i].cnt = Math.min(dp[i].cnt, dp[i / 2].cnt + 1);
                dp[i].preIdx = (dp[i].cnt == dp[i / 2].cnt + 1 ? i / 2 : dp[i].preIdx);
            }
            dp[i].cnt = Math.min(dp[i].cnt, dp[i - 1].cnt + 1);
            dp[i].preIdx = (dp[i].cnt == dp[i - 1].cnt + 1 ? i - 1 : dp[i].preIdx);
        }

        System.out.println(dp[n].cnt);

        StringBuilder sb = new StringBuilder();
        int idx = n;
        while (idx > 0) {
            sb.append(idx).append(" ");
            idx = dp[idx].preIdx;
        }
        System.out.println(sb.toString().trim());
    }
}

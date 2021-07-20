import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        int[] dp = new int[n];
        int max = -1;

        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(str[i]);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if(dp[i] == 0) dp[i] = 1;
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }
}

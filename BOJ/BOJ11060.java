import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];

        String[] str = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            num[i] = Integer.parseInt(str[i]);

        if(n==1 || num[0]!=0){
            dp[0] = 1;
            for(int i=0;i<n-1;i++){
                int jump = num[i];
                for(int j=1;j<=jump;j++){
                    if(i+j>=n) break; // ArrayIndexOutOfBoundsException
                    if(dp[i]==0) break; // 도달할 수 없음

                    if(dp[i+j]==0 || dp[i+j]>dp[i]+1)
                        dp[i+j] = dp[i] + 1;
                }
            }
        }

        System.out.print(dp[n-1]-1);
    }
}
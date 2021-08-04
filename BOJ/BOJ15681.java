import java.io.*;
import java.util.*;

public class BOJ15681 {
    static ArrayList<Integer>[] tree;
    static int[] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            tree[i] = new ArrayList<Integer>();
        dp = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        visited[r] = true;
        dfs(r);

        StringBuilder sb = new StringBuilder();
        while(q-->0){
            int query = Integer.parseInt(br.readLine());

            sb.append(Integer.toString(dp[query])+'\n');
        }
        System.out.print(sb.toString());
    }
    public static int dfs(int cur){
        dp[cur] = 1;
        for(int t:tree[cur]){
            if(!visited[t]){
                visited[t] = true;
                dp[cur] += dfs(t);
            }
        }
        return dp[cur];
    }
}
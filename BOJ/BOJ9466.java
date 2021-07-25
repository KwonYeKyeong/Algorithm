import java.io.*;
import java.util.*;

public class BOJ9466 {
    static int[] partner;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());

            cnt = 0;
            partner = new int[n+1];
            visited = new boolean[n+1];
            
            String[] str = br.readLine().split(" ");
            for(int i=1;i<=n;i++){
                partner[i] = Integer.parseInt(str[i-1]);
                if(i==partner[i]){
                    visited[i] = true;
                    cnt++;
                }
            }

            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    visited[i] = true;
                    dfs(partner[i], list);
                }
            }

            System.out.println(n-cnt);
        }
    }
    public static void dfs(int p, ArrayList<Integer> list){
        if(!visited[p]){
            list.add(p);
            visited[p] = true;
            dfs(partner[p], list);
        }
        else if(list.contains(p))
            cnt += list.size() - list.indexOf(p);
        return;
    }  
}

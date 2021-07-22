import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            list[i] = new ArrayList<Integer>();
        
        for(int i=1;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }

        int[] result = new int[n+1];
        
        dfs(1, 0, list, result);

        for(int i=2;i<=n;i++)
            System.out.println(result[i]);
    }
    public static void dfs(int r, int parent, ArrayList<Integer>[] list, int[] result){
        result[r] = parent;
        for(int i : list[r]){
            if(i==parent) continue;
            dfs(i, r, list, result);
        }
    }
}

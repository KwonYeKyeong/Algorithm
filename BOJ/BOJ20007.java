import java.io.*;
import java.util.*;

public class BOJ20007 {
    public static class Pair implements Comparable<Pair>{
        int num;
        int weight;
    
        Pair(int n, int w){
            num = n;
            weight = w;
        }
    
        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        final int INF = Integer.MAX_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Pair>[] list = new ArrayList[1000];
        int[] d = new int[1000];

        for(int i=0;i<1000;i++)
            list[i] = new ArrayList<Pair>();
        for(int i=0;i<1000;i++)
            d[i] = INF;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        while(m-->0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Pair(b, c));
            list[b].add(new Pair(a, c));
        }

        d[y] = 0;
        pq.offer(new Pair(y, 0));
        while(!pq.isEmpty()){
            int num = pq.peek().num;
            int weight = pq.peek().weight;
            pq.poll();

            for(int i=0;i<list[num].size();i++){
                int nn = list[num].get(i).num;
                int ww = weight + list[num].get(i).weight;
                if(d[nn]>ww){
                    d[nn] = ww;
                    pq.add(new Pair(nn, ww));
                }
            }
        }

        Arrays.sort(d, 0, n);

        if(2 * d[n-1] > x) 
            System.out.print(-1);
        else{
            int today = 0, cnt = 1;
                for(int i=1;i<n;i++){
                if(today + 2* d[i] <= x)
                    today += 2 * d[i];
                else{
                    today = 2 * d[i];
                    cnt++;
                }
            }
            System.out.print(cnt);
        }
    }
}

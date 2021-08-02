import java.io.*;
import java.util.*;

class Game {
    String name;
    int power;

    Game(String n, int p){
        name = n;
        power = p;
    }
}
public class BOJ19637 {
    public static void main(String[] args) throws IOException {
        ArrayList<Game> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            list.add(new Game(name, power));
        }

        StringBuilder sb = new StringBuilder();
        while(m-->0){
            int p = Integer.parseInt(br.readLine());

            int start = 0, end = list.size()-1, mid = 0;
            while(start<=end){
                mid = (start+end)/2;

                if(p<=list.get(mid).power)
                    end = mid-1;
                else start = mid+1;
            }
            sb.append(list.get(start).name).append('\n');
        }
        System.out.println(sb.toString());
    }
}

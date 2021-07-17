import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class BOJ9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            ArrayList<Point> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());

            for(int i=0;i<(n+2);i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int tmpX = Integer.parseInt(st.nextToken());
                int tmpY = Integer.parseInt(st.nextToken());
                list.add(new Point(tmpX, tmpY));
            }
            /*********** 입력 끝 ***********/
            Queue<Point> q = new LinkedList<>();
            boolean[] visited = new boolean[n+2];

            Point start = list.get(0);
            Point end = list.get(n+1);
            boolean check = false;

            q.offer(start);
            visited[0] = true;

            while(!q.isEmpty()){
                Point p = q.poll();
                
                if(p.equals(end)){
                    System.out.println("happy");
                    check = true;
                    break;
                }
                else{
                    for(int i=1;i<list.size();i++){
                        if(visited[i] == false && abs(p.x, list.get(i).x) + abs(p.y, list.get(i).y) <= 1000){
                            q.add(list.get(i));
                            visited[i] = true;
                        }
                    }
                }
            }
            if(check == false) System.out.print("sad");            
        }
    }
    public static int abs(int a, int b){
        return (a<b?b-a:a-b);
    }
}

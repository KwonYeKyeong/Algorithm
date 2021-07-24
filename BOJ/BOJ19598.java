import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    Meeting(int s, int e){
        start = s;
        end = e;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.start == o.start)
            return this.end - o.end;
        return this.start - o.start;
    }
}
public class BOJ19598 {
    public static void main(String[] args) throws IOException {
        ArrayList<Meeting> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Meeting(s, e));
        }

        // 회의의 시작시간 기준으로 오름차순 정렬
        Collections.sort(list);

        int cnt = -1; // 회의실 개수
        for(Meeting m : list){
            while(!pq.isEmpty() && pq.peek()<=m.start)
                pq.poll();
            pq.offer(m.end);

            cnt = (cnt<pq.size()?pq.size():cnt);
        }

        System.out.println(cnt);
    }
}
import java.util.PriorityQueue;

class PG42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for (int s : scoville)
            pq.add(s);

        while (pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }

            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b * 2);
            answer++;
        }

        return answer;
    }
}

import java.util.*;

public class PG118667 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for (int q : queue1) {
            q1.offer(q);
            sum1 += q;
        }
        for (int q : queue2) {
            q2.offer(q);
            sum2 += q;
        }

        while (sum1 != sum2) {
            if (sum1 < sum2) {
                int top2 = q2.poll();
                sum2 -= top2;
                q1.offer(top2);
                sum1 += top2;
            } else if (sum1 > sum2) {
                int top1 = q1.poll();
                sum1 -= top1;
                q2.offer(top1);
                sum2 += top1;
            }
            answer++;

            if (answer >= (queue1.length + queue2.length) * 2) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}

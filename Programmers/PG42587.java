import java.util.*;

public class PG42587 {

    public class Print {
        int priority;
        int location;

        Print(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Print> queue = new LinkedList<>();
        int[] count = new int[10];
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Print(priorities[i], i));
            count[priorities[i]]++;
        }

        int highest = 9;
        while (count[highest] == 0) {
            highest--;
        }

        while (!queue.isEmpty()) {
            Print p = queue.poll();

            if (p.priority == highest) {
                count[highest]--;
                while (count[highest] == 0 && highest > 0) {
                    highest--;
                }

                answer++;
                if (p.location == location) {
                    break;
                }
            } else {
                queue.add(p);
            }
        }

        return answer;
    }

}

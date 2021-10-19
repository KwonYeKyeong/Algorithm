import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PG42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int daysToComplete = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0)
                daysToComplete++;
            queue.add(daysToComplete);
        }

        while (true) {
            int q = queue.poll();
            int count = 1;
            while (!queue.isEmpty() && q >= queue.peek()) {
                queue.poll();
                count++;
            }
            answerList.add(count);

            if(queue.isEmpty()) break;
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}

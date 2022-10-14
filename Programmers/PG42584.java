import java.util.Stack;

public class PG42584 {

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        // 3) original ver.
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         if (prices[i] <= prices[j]) {
        //             continue;
        //         }
        //         answer[i] = j - i;
        //         break;
        //     }
        //     if (i != n - 1 && answer[i] == 0) {
        //         answer[i] = n - i - 1;
        //     }
        // }
        // answer[n - 1] = 0;

        // 2) 이중 for문(다른 사람 풀이)
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         answer[i]++;
        //         if (prices[i] > prices[j]) {
        //             break;
        //         }
        //     }
        // }

        // 1) 스택
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }

}

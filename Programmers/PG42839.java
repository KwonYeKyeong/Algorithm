import java.util.*;

public class PG42839 {

    public Set<Integer> set;

    public int solution(String numbers) {
        set = new HashSet<>();
        String[] splitNumbers = numbers.split("");
        for (int i = 0; i < splitNumbers.length; i++) {
            StringBuilder sb = new StringBuilder();
            boolean[] visited = new boolean[splitNumbers.length];
            sb.append(splitNumbers[i]);
            visited[i] = true;
            set.add(Integer.parseInt(sb.toString()));
            brute_force(splitNumbers, visited, sb);
        }

        int answer = 0;
        for (int n : set) {
            if (isPrimeNumber(n)) {
                answer++;
            }
        }

        return answer;
    }

    public void brute_force(String[] numbers, boolean[] visited, StringBuilder sb) {
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }
            sb.append(numbers[i]);
            visited[i] = true;
            set.add(Integer.parseInt(sb.toString()));
            brute_force(numbers, visited, sb);
            sb.deleteCharAt(sb.length() - 1); // 마지막 문자 지우기
            visited[i] = false;
        }
    }

    public boolean isPrimeNumber(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

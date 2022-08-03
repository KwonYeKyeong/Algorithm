import java.util.Arrays;

public class PG42883 {

    public int n;

    public String solution(String number, int k) {
        n = number.length();
        boolean[] check = new boolean[n];
        Arrays.fill(check, true);
        int c = 0;

        for (int i = 1; i < n; i++) {
            int previous = i - 1;
            while (c < k && !outOfBound(previous) && number.charAt(previous) < number.charAt(i)) {
                if (check[previous]) {
                    c++;
                }
                check[previous] = false;
                previous--;
            }
        }

        if (c == 0) { // 예외 : "87654321" 3 => "87654"
            for (int i = n - k; i < n; i++) {
                check[i] = false;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                answer.append(number.charAt(i));
            }
        }
        return answer.toString();
    }

    public boolean outOfBound(int x) {
        if (x >= 0 && x < n) {
            return false;
        }
        return true;
    }

}
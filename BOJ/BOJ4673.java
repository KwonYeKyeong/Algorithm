import java.util.*;

public class BOJ4673 {

    public static void main(String[] args) {
        boolean[] selfNumbers = new boolean[10001];
        Arrays.fill(selfNumbers, true);

        int number = 0;
        while (++number <= 10000) {
            int n = number;
            int sum = n;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }

            if (sum <= 10000) {
                selfNumbers[sum] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (selfNumbers[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}
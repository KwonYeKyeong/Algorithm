public class PG92335 {
    public int solution(int n, int k) { // 1 ≤ n ≤ 1,000,000 | 3 ≤ k ≤ 10
        int answer = 0;

        String number = changeNumber(n, k);
        String[] numbers = number.split("0");

        for (String num : numbers) {
            if (num.equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(num))) {
                /*
                 * int가 아니라 long으로 변환하는 이유
                 * : 3^7 = 2x10^3 -> 3^14 = 4x10^6
                 *   14자리 정수는 int범위(2*10^9)를 벗어남.
                 */
                answer++;
            }
        }

        return answer;
    }

    public String changeNumber(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > k) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);

        return sb.reverse().toString();
    }

    public boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
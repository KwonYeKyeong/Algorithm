public class PG12899 {

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n / 3 > 0) {
            if (n % 3 == 0) {
                sb.append(3);
                n = n / 3 - 1;
            } else {
                sb.append(n % 3);
                n = n / 3;
            }
        }

        if (n % 3 != 0) {
            sb.append(n % 3);
        }

        sb.reverse();
        String answer = sb.toString().replace("3", "4");

        return answer;
    }

}

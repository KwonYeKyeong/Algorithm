// 오답

public class PG42860 {

    public int solution(String name) {
        int answer = 0;

        int startA, endA;
        int moves = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                startA = i;

                endA = startA;
                while (endA + 1 < name.length() && name.charAt(endA + 1) == 'A') {
                    endA++;
                }

                moves = moves < (startA - 1) * 2 + name.length() - endA - 1 ? moves
                        : (startA - 1) * 2 + name.length() - endA - 1;
            }

            if (name.charAt(i) <= 'N') {
                answer += name.charAt(i) - 'A';
            } else {
                answer += 'Z' - name.charAt(i) + 1;
            }
        }

        answer += moves;

        int justRight = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) <= 'N') {
                justRight += name.charAt(i) - 'A' + 1;
            } else {
                justRight += 'Z' - name.charAt(i) + 2;
            }
        }

        answer = answer < justRight - 1 ? answer : justRight - 1;

        return answer;
    }

}

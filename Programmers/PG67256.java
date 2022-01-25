import java.util.*;

public class PG67256 {

    public class Hand {
        int x;
        int y;

        Hand(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String solution(int[] numbers, String hand) {
        Map<Integer, Hand> map = new HashMap<>();
        map.put(0, new Hand(3, 1));
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(num++, new Hand(i, j));
            }
        }
        Hand left = new Hand(3, 0), right = new Hand(3, 2);
        StringBuilder answer = new StringBuilder();

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                left = map.get(number);
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = map.get(number);
            } else {
                Hand target = map.get(number);
                if (calculateDistance(left, target) < calculateDistance(right, target)) {
                    answer.append("L");
                    left = target;
                } else if (calculateDistance(left, target) > calculateDistance(right, target)) {
                    answer.append("R");
                    right = target;
                } else {// 거리가 동일할 때
                    if (hand.toUpperCase().charAt(0) == 'L') {
                        left = target;
                    } else if (hand.toUpperCase().charAt(0) == 'R') {
                        right = target;
                    }
                    answer.append(hand.toUpperCase().charAt(0));
                }
            }
        }

        return answer.toString();
    }

    public int calculateDistance(Hand h1, Hand h2) {
        return Math.abs(h1.x - h2.x) + Math.abs(h1.y - h2.y);
    }

}

import java.io.*;
import java.util.*;

public class BOJ21608 {

    public static final int[][] DIR = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    public static final int[] SCORE = { 0, 1, 10, 100, 1000 };

    public static int n;
    public static String[][] seats;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        seats = new String[n + 1][n + 1];
        int[][] seats_left = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i == 1 && (j == 1 || j == n)) || (i == n && (j == 1 || j == n))) {
                    seats_left[i][j] = 2;
                } else if ((i == 1 && !(j == 1 || j == n)) || (i == n && !(j == 1 || j == n)) ||
                        (j == 1 && !(i == 1 || i == n)) || (j == n && !(i == 1 || i == n))) {
                    seats_left[i][j] = 3;
                } else {
                    seats_left[i][j] = 4;
                }
            }
        }
        Map<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i < n * n; i++) {
            String[] input = br.readLine().split(" ");
            String student = input[0];
            map.put(student, new HashSet<>());
            for (int j = 1; j < input.length; j++) {
                map.get(student).add(input[j]);
            }

            int max = -1, max_x = 0, max_y = 0; // max 초기화를 -1로 하는 것이 중요!(max = 0으로 하면 seat에 값이 안 들어갈 수 도 있다)
            boolean near_friend = false;
            int sit_with_friends = 0;
            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    if (seats[x][y] != null) {
                        continue;
                    }

                    int friends = 0;
                    for (int d = 0; d < 4; d++) {
                        int nextX = x + DIR[d][0];
                        int nextY = y + DIR[d][1];
                        if (!outOfBound(nextX, nextY) && seats[nextX][nextY] != null) {
                            if (map.get(student).contains(seats[nextX][nextY])) {
                                friends++;
                                if (!near_friend) {
                                    near_friend = true;
                                    max = -1;
                                }
                            }
                        }
                    }
                    if (sit_with_friends < friends || (sit_with_friends == friends && max < seats_left[x][y])) {
                        sit_with_friends = friends;
                        max = seats_left[x][y];
                        max_x = x;
                        max_y = y;
                    }

                    if (!near_friend && max < seats_left[x][y]) {
                        max = seats_left[x][y];
                        max_x = x;
                        max_y = y;
                    }
                }
            }

            seats[max_x][max_y] = student;
            for (int d = 0; d < 4; d++) {
                int nextX = max_x + DIR[d][0];
                int nextY = max_y + DIR[d][1];
                if (!outOfBound(nextX, nextY)) {
                    seats_left[nextX][nextY]--;
                }
            }
        }

        System.out.println(calculate_satisfaction_score(map));
    }

    public static boolean outOfBound(int x, int y) {
        if (x >= 1 && x <= n && y >= 1 && y <= n) {
            return false;
        }
        return true;
    }

    public static int calculate_satisfaction_score(Map<String, Set<String>> map) {
        int score = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int x = i + DIR[d][0];
                    int y = j + DIR[d][1];
                    if (!outOfBound(x, y) && map.get(seats[i][j]).contains(seats[x][y])) {
                        cnt++;
                    }
                }
                score += SCORE[cnt];
            }
        }

        return score;
    }

}

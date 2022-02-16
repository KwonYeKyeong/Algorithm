import java.io.*;
import java.util.*;

public class BOJ2206 {

    public static final int FALSE = 0;
    public static final int TRUE = 1;
    public static final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static class Wall {
        int x;
        int y;
        int destroyed; // 벽을 부순 적이 있는지
        int distance;

        Wall(int x, int y, int destroyed, int distance) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.distance = distance;
        }
    }

    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        Character[][] map = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        Queue<Wall> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2]; // 0 : 벽 부순 적 없음, 1 : 벽 부순 적 있음
        /*
         * visited 배열을 2차원이 아닌 3차원으로 선언한 이유
         * -> 벽을 부수지 않고 이동했을 때와 벽을 부수고 이동했을 때의 방문여부를 각각
         */

        queue.add(new Wall(0, 0, FALSE, 1));
        visited[0][0][FALSE] = true;
        while (!queue.isEmpty()) {
            Wall w = queue.poll();

            if (w.x == n - 1 && w.y == m - 1) {
                answer = answer > w.distance ? w.distance : answer;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = w.x + dir[i][0];
                int nextY = w.y + dir[i][1];
                if (!outOfBound(nextX, nextY)) {
                    if (map[nextX][nextY] == '0' && !visited[nextX][nextY][w.destroyed]) {
                        queue.add(new Wall(nextX, nextY, w.destroyed, w.distance + 1));
                        visited[nextX][nextY][w.destroyed] = true;
                    } else if (map[nextX][nextY] == '1' && w.destroyed == FALSE) {
                        queue.add(new Wall(nextX, nextY, TRUE, w.distance + 1));
                        visited[nextX][nextY][TRUE] = true;
                    }
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static boolean outOfBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return false;
        }
        return true;
    }

}
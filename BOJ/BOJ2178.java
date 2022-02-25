import java.io.*;
import java.util.*;

public class BOJ2178 {

    public static final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] visited = new int[n][m];

        queue.add(0);
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int q = queue.poll();
            int x = q / 1000;
            int y = q % 1000;

            if (x == n - 1 && y == m - 1) {
                System.out.println(visited[x][y]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];
                if (!outOfBound(nextX, nextY) && map[nextX][nextY] == '1' && visited[nextX][nextY] == 0) {
                    queue.add(nextX * 1000 + nextY);
                    visited[nextX][nextY] = visited[x][y] + 1;
                }
            }
        }
    }

    public static boolean outOfBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return false;
        }
        return true;
    }

}

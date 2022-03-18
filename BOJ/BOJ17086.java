import java.io.*;
import java.util.*;

public class BOJ17086 {

    public static final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 1 }, { 1, 1 }, { 1, -1 },
            { -1, -1 } };

    public static int n, m;
    public static String[][] map;

    // 1) 아기 상어가 없는 곳을 일일히 다 방문하는 방법(메모리 : 175748KB, 시간 : 696ms)
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     String[] nm = br.readLine().split(" ");
    //     n = Integer.parseInt(nm[0]);
    //     m = Integer.parseInt(nm[1]);

    //     map = new String[n][m];
    //     for (int i = 0; i < n; i++) {
    //         map[i] = br.readLine().split(" ");
    //     }

    //     int maxLength = Integer.MIN_VALUE;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             if (map[i][j].equals("0")) {
    //                 maxLength = Math.max(maxLength, bfs(i, j));
    //             }
    //         }
    //     }

    //     System.out.println(maxLength);
    // }

    // public static int bfs(int x, int y) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     int[][] visited = new int[n][m];
    //     for (int i = 0; i < n; i++) {
    //         Arrays.fill(visited[i], -1);
    //     }
    //     int length = Integer.MIN_VALUE;

    //     queue.add(x * 100 + y);
    //     visited[x][y] = 0;
    //     while (!queue.isEmpty()) {
    //         int q = queue.poll();
    //         int curX = q / 100;
    //         int curY = q % 100;

    //         if (map[curX][curY].equals("1") && !(curX == x && curY == y)) {
    //             length = visited[curX][curY];
    //             break;
    //         }

    //         for (int i = 0; i < 8; i++) {
    //             int nextX = curX + dir[i][0];
    //             int nextY = curY + dir[i][1];
    //             if (!outOfBound(nextX, nextY) && visited[nextX][nextY] == -1) {
    //                 queue.add(nextX * 100 + nextY);
    //                 visited[nextX][nextY] = visited[curX][curY] + 1;
    //             }
    //         }
    //     }

    //     return length;
    // }

    // public static boolean outOfBound(int x, int y) {
    //     if (x >= 0 && x < n && y >= 0 && y < m) {
    //         return false;
    //     }
    //     return true;
    // }

    // 2) 아기 상어가 있는 곳에서 시작해서 가장 먼 곳을 찾는 방법(메모리 : 14540KB, 시간 : 136ms)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new String[n][m];
        Queue<Integer> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("1")) {
                    queue.add(i * 100 + j);
                    visited[i][j] = 1;
                }
            }
        }

        int maxLength = 0;
        while (!queue.isEmpty()) {
            int q = queue.poll();
            int curX = q / 100;
            int curY = q % 100;

            maxLength = Math.max(maxLength, visited[curX][curY] - 1);

            for (int i = 0; i < 8; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (!outOfBound(nextX, nextY) && visited[nextX][nextY] == 0) {
                    queue.add(nextX * 100 + nextY);
                    visited[nextX][nextY] = visited[curX][curY] + 1;
                }
            }
        }

        System.out.println(maxLength);
    }

    public static boolean outOfBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return false;
        }
        return true;
    }

}
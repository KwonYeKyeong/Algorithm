import java.io.*;

public class BOJ14500 {

    public static int[][] direction = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
    public static int n, m;
    public static String[][] map;
    public static boolean[][] visited;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new String[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        max = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tetromino1(0, 0, i, j);
                tetromino2(i, j);

                claerVisited();
            }
        }

        System.out.println(max);
    }

    private static void tetromino1(int cnt, int value, int x, int y) {
        if (cnt == 4) {
            max = max < value ? value : max;
            return;
        }

        value += Integer.parseInt(map[x][y]);
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (!outOfBound(nextX, nextY) && !visited[nextX][nextY]) {
                tetromino1(cnt + 1, value, nextX, nextY);
                visited[nextX][nextY] = false;
            }
        }
    }

    private static void tetromino2(int x, int y) {
        int value = 0;
        if (!outOfBound(x + 1, y - 2)) { // ㅜ
            value = value < Integer.parseInt(map[x][y]) + Integer.parseInt(map[x][y - 1])
                    + Integer.parseInt(map[x][y - 2]) + Integer.parseInt(map[x + 1][y - 1])
                            ? Integer.parseInt(map[x][y]) + Integer.parseInt(map[x][y - 1])
                                    + Integer.parseInt(map[x][y - 2]) + Integer.parseInt(map[x + 1][y - 1])
                            : value;
        }
        if (!outOfBound(x + 2, y + 1)) { // ㅏ
            value = value < Integer.parseInt(map[x][y]) + Integer.parseInt(map[x + 1][y])
                    + Integer.parseInt(map[x + 2][y]) + Integer.parseInt(map[x + 1][y + 1])
                            ? Integer.parseInt(map[x][y]) + Integer.parseInt(map[x + 1][y])
                                    + Integer.parseInt(map[x + 2][y]) + Integer.parseInt(map[x + 1][y + 1])
                            : value;
        }
        if (!outOfBound(x - 1, y + 2)) { // ㅗ
            value = value < Integer.parseInt(map[x][y]) + Integer.parseInt(map[x][y + 1])
                    + Integer.parseInt(map[x][y + 2]) + Integer.parseInt(map[x - 1][y + 1])
                            ? Integer.parseInt(map[x][y]) + Integer.parseInt(map[x][y + 1])
                                    + Integer.parseInt(map[x][y + 2]) + Integer.parseInt(map[x - 1][y + 1])
                            : value;
        }
        if (!outOfBound(x - 2, y - 1)) { // ㅓ
            value = value < Integer.parseInt(map[x][y]) + Integer.parseInt(map[x - 1][y])
                    + Integer.parseInt(map[x - 2][y]) + Integer.parseInt(map[x - 1][y - 1])
                            ? Integer.parseInt(map[x][y]) + Integer.parseInt(map[x - 1][y])
                                    + Integer.parseInt(map[x - 2][y]) + Integer.parseInt(map[x - 1][y - 1])
                            : value;
        }
        max = max < value ? value : max;
    }

    private static boolean outOfBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return false;
        }
        return true;
    }

    // visited를 clear하지않고 매번 new로 생성해주면 시간초과가 남
    private static void claerVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

}
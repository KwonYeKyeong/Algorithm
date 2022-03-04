import java.io.*;

public class BOJ2468 {

    public static final int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int[][] map;
    public static boolean[][] visited;
    public static int n;
    public static int maxArea = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int maxHeight = 2;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int height = -1, area = 0;
        while (++height <= maxHeight) { // height 시작이 0부터인 이유 : 비가 안 올 경우 때문
            visited = new boolean[n][n];
            area = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > height && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j, height);
                        area++;
                    }
                }
            }
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }

    public static void dfs(int a, int b, int h) {
        for (int i = 0; i < 4; i++) {
            int nextA = a + dir[i][0];
            int nextB = b + dir[i][1];
            if (!outOfBound(nextA, nextB) && map[nextA][nextB] > h && !visited[nextA][nextB]) {
                visited[nextA][nextB] = true;
                dfs(nextA, nextB, h);
            }
        }
    }

    public static boolean outOfBound(int a, int b) {
        if (a >= 0 && a < n && b >= 0 && b < n) {
            return false;
        }
        return true;
    }

}

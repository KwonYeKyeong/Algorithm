import java.io.*;
import java.util.*;

public class BOJ16234 {

    public static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int[][] world;
    public static int n, l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NLR = br.readLine().split(" ");
        n = Integer.parseInt(NLR[0]);
        l = Integer.parseInt(NLR[1]);
        r = Integer.parseInt(NLR[2]);

        world = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                world[i][j] = Integer.parseInt(input[j]);
            }
        }

        int migration = 0;
        while (true) {
            boolean check = false;
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        continue;
                    }

                    List<Integer> list = new ArrayList<>();
                    int sum = bfs(visited, i, j, list);

                    if (list.size() <= 1) {
                        continue;
                    }
                    check = true;
                    // 인구 이동
                    sum /= list.size();
                    for (int xy : list) {
                        int x = xy / 100;
                        int y = xy % 100;
                        world[x][y] = sum;
                    }
                }
            }

            if (!check) {
                break;
            }
            migration++;
        }

        System.out.println(migration);
    }

    public static int bfs(boolean[][] visited, int x, int y, List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;

        visited[x][y] = true;
        queue.add(x * 100 + y);
        while (!queue.isEmpty()) {
            int q = queue.poll();
            list.add(q);
            int curX = q / 100;
            int curY = q % 100;
            sum += world[curX][curY];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + DIR[i][0];
                int nextY = curY + DIR[i][1];
                if (!outOfBound(nextX, nextY) && !visited[nextX][nextY]) {
                    if (Math.abs(world[curX][curY] - world[nextX][nextY]) >= l
                            && Math.abs(world[curX][curY] - world[nextX][nextY]) <= r) {
                        visited[nextX][nextY] = true;
                        queue.add(nextX * 100 + nextY);
                    }
                }
            }
        }

        return sum;
    }

    public static boolean outOfBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return false;
        }
        return true;
    }

}

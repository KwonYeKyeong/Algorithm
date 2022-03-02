import java.io.*;
import java.util.*;

public class BOJ7569 {

    public static final int[][] dir = {
            { 1, 0, 0 },
            { -1, 0, 0 },
            { 0, 1, 0 },
            { 0, -1, 0 },
            { 0, 0, 1 },
            { 0, 0, -1 }
    };

    public static class Location {
        int a;
        int b;
        int c;

        Location(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int m, n, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] boxInfo = br.readLine().split(" ");
        m = Integer.parseInt(boxInfo[0]);
        n = Integer.parseInt(boxInfo[1]);
        h = Integer.parseInt(boxInfo[2]);

        String[][][] box = new String[m][n][h];
        Queue<Location> queue = new LinkedList<>();
        int[][][] visited = new int[m][n][h];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < h; k++) {
                    visited[i][j][k] = -1;
                }
            }
        }
        int youngPotatos = 0;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                String[] potatos = br.readLine().split(" ");
                for (int x = 0; x < m; x++) {
                    box[x][y][z] = potatos[x];

                    if (box[x][y][z].equals("1")) {
                        queue.add(new Location(x, y, z));
                        visited[x][y][z] = 0;
                    } else if (box[x][y][z].equals("0")) {
                        youngPotatos++;
                    }
                }
            }
        }

        int days = -1;
        while (!queue.isEmpty()) {
            Location q = queue.poll();

            days = days < visited[q.a][q.b][q.c] ? visited[q.a][q.b][q.c] : days;

            for (int i = 0; i < 6; i++) {
                int nextX = q.a + dir[i][0];
                int nextY = q.b + dir[i][1];
                int nextZ = q.c + dir[i][2];
                if (!outOfBound(nextX, nextY, nextZ) &&
                        visited[nextX][nextY][nextZ] == -1 &&
                        box[nextX][nextY][nextZ].equals("0")) {
                    queue.add(new Location(nextX, nextY, nextZ));
                    visited[nextX][nextY][nextZ] = visited[q.a][q.b][q.c] + 1;
                    youngPotatos--;
                }
            }
        }

        if (youngPotatos > 0) {
            days = -1;
        }

        System.out.println(days);
    }

    public static boolean outOfBound(int x, int y, int z) {
        if (x >= 0 && x < m && y >= 0 && y < n && z >= 0 && z < h) {
            return false;
        }
        return true;
    }

}
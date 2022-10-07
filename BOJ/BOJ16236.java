import java.io.*;
import java.util.*;

public class BOJ16236 {

    public static final int SHARK_SIZE = 2;
    public static final int[][] DIR = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    static class Shark {
        int x;
        int y;
        int distance;

        Shark(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        Map<Integer, Integer> fishes = new HashMap<>();
        int sharkX = 0, sharkY = 0;
        int size = SHARK_SIZE;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                } else if (map[i][j] > 0) {
                    fishes.put(map[i][j], fishes.getOrDefault(map[i][j], 0) + 1);
                }
            }
        }

        int time = 0, fishCnt = 0;
        while (fishesLeft(size, fishes)) {
            int startX = sharkX, startY = sharkY;
            PriorityQueue<Shark> pq = new PriorityQueue<>(new Comparator<Shark>() {
                @Override
                public int compare(Shark s1, Shark s2) {
                    if (s1.distance == s2.distance) {
                        if (s1.x == s2.x) {
                            return s1.y - s2.y;
                        }
                        return s1.x - s2.x;
                    }
                    return s1.distance - s2.distance;
                }
            });
            boolean[][] visited = new boolean[n][n];

            pq.add(new Shark(sharkX, sharkY, 0));
            visited[sharkX][sharkY] = true;
            while (!pq.isEmpty()) {
                Shark s = pq.poll();

                if (map[s.x][s.y] > 0 && map[s.x][s.y] < size) {
                    fishes.put(map[s.x][s.y], fishes.get(map[s.x][s.y]) - 1);
                    map[s.x][s.y] = 0;
                    fishCnt++;
                    sharkX = s.x;
                    sharkY = s.y;
                    time += s.distance;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = s.x + DIR[i][0];
                    int nextY = s.y + DIR[i][1];
                    if (outOfBound(nextX, nextY, n) || visited[nextX][nextY] || size < map[nextX][nextY]) {
                        continue;
                    }
                    pq.add(new Shark(nextX, nextY, s.distance + 1));
                    visited[nextX][nextY] = true;
                }
            }

            if (size == fishCnt) {
                size++;
                fishCnt = 0;
            }

            if (startX == sharkX && startY == sharkY) { // 상어 주변에 상어보다 큰 물고기로 둘러싸임
                break;
            }
        }

        System.out.println(time);
    }

    public static boolean fishesLeft(int size, Map<Integer, Integer> fishes) {
        for (int i = 1; i < size; i++) {
            if (fishes.containsKey(i) && fishes.get(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean outOfBound(int x, int y, int n) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return false;
        }
        return true;
    }

}
import java.io.*;
import java.util.*;

public class BOJ15686 {

    public static class Location {
        private int x;
        private int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static int n, m;
    public static List<Location> home, chicken;
    public static int result = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        String map[][] = new String[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("1")) {
                    home.add(new Location(i, j));
                }
                if (map[i][j].equals("2")) {
                    chicken.add(new Location(i, j));
                }
            }
        }

        // 폐업하지 않을 치킨집 선별하기
        dfs(0, new boolean[chicken.size()], new ArrayList<Integer>());

        System.out.println(result);
    }

    public static void dfs(int next, boolean[] visited, List<Integer> indexList) {
        if (indexList.size() == m) {
            result = Math.min(result, calculateChickenDistance(indexList));
            return;
        }

        for (int i = next; i < visited.length; i++) {
            if (!visited[i]) {
                indexList.add(i);
                visited[i] = true;

                dfs(i + 1, visited, indexList);

                indexList.remove(Integer.valueOf(i));
                visited[i] = false;
            }
        }
    }

    public static int calculateChickenDistance(List<Integer> indexList) {
        int chickenDistance = 0;

        for (Location h : home) {
            int distance = 2 * n;
            for (int index : indexList) {
                int valueX = h.getX() - chicken.get(index).getX();
                int valueY = h.getY() - chicken.get(index).getY();
                distance = distance < Math.abs(valueX) + Math.abs(valueY) ? distance
                        : Math.abs(valueX) + Math.abs(valueY);
            }
            chickenDistance += distance;
        }

        return chickenDistance;
    }

}
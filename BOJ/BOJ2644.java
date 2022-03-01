import java.io.*;
import java.util.*;

public class BOJ2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        int m = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            List<Integer> valueList1 = map.get(x);
            valueList1.add(y);
            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }
            List<Integer> valueList2 = map.get(y);
            valueList2.add(x);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        queue.add(a);
        visited[a] = 0;
        while (!queue.isEmpty()) {
            int q = queue.poll();

            if (q == b) {
                break;
            }
            for (int v : map.get(q)) {
                if (visited[v] == -1) {
                    queue.add(v);
                    visited[v] = visited[q] + 1;
                }
            }
        }

        System.out.println(visited[b]);
    }

}
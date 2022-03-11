import java.util.*;

public class PG42861 {

    public int[] parents;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[2] == b[2]) {
                    return a[0] - b[0];
                }
                return a[2] - b[2];
            }
        });

        parents = new int[n];
        for (int i = 0; i < n; i++) { // 시작은 자기자신이 부모
            parents[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            int start = findParent(costs[i][0]);
            int end = findParent(costs[i][1]);

            if (parents[start] == parents[end]) { // 사이클 방지
                continue;
            } else {
                parents[end] = start;
                answer += costs[i][2];
            }
        }
        return answer;
    }

    public int findParent(int node) {
        if (node == parents[node]) {
            return node;
        }
        return findParent(parents[node]);
    }

}
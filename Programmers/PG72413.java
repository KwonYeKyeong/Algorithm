import java.util.*;

public class PG72413 {

    public class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public Map<Integer, List<Node>> graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        int[] startS = dijkstra(n, s);
        int[] startA = dijkstra(n, a);
        int[] startB = dijkstra(n, b);

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, startS[i] + startA[i] + startB[i]);
        }

        return answer;
    }

    public int[] dijkstra(int n, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.cost - n2.cost;
            }
        });
        int[] D = new int[n + 1];
        Arrays.fill(D, Integer.MAX_VALUE);

        D[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost > D[node.idx]) { // 재방문 check
                continue;
            }

            for (Node nextNode : graph.get(node.idx)) {
                if (D[nextNode.idx] > D[node.idx] + nextNode.cost) {
                    D[nextNode.idx] = D[node.idx] + nextNode.cost;
                    pq.offer(new Node(nextNode.idx, D[nextNode.idx]));
                }
            }
        }

        return D;
    }

}
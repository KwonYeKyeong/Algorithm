import java.util.*;

public class PG81302 {

    public int[] solution(String[][] places) {
        List<Integer> players = new ArrayList<>();
        int[] answer = new int[5];

        int idx = 0;
        for (String[] place : places) {
            boolean possible = true;

            // 응시자 위치 확인
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        players.add(10 * i + j);
                    }
                }
            }

            int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            boolean[] visited = new boolean[45];
            int distance;
            for (int player : players) {
                // BFS
                Queue<Integer> queue = new LinkedList<>();

                queue.add(player);
                visited[player] = true;
                while (!queue.isEmpty()) {
                    int p = queue.poll();
                    int x = p / 10;
                    int y = p % 10;

                    for (int i = 0; i < 4; i++) {
                        int nextX = x + direction[i][0];
                        int nextY = y + direction[i][1];
                        if (!outOfBound(nextX, nextY) && !visited[nextX * 10 + nextY]) {
                            distance = Math.abs(player / 10 - nextX) + Math.abs(player % 10 - nextY);
                            if (distance > 2) {
                                continue;
                            }

                            switch (place[nextX].charAt(nextY)) {
                                case 'P' -> {
                                    if (distance <= 2) {
                                        possible = false;
                                        break;
                                    }
                                    queue.add(nextX * 10 + nextY);
                                    visited[nextX * 10 + nextY] = true;
                                }
                                case 'O' -> {
                                    queue.add(nextX * 10 + nextY);
                                    visited[nextX * 10 + nextY] = true;
                                }
                                case 'X' -> {
                                    continue;
                                }
                            }
                        }
                    }
                }

                if (!possible) {
                    break;
                }

                visited = clearVisited(visited);
            }

            answer[idx++] = (possible == true ? 1 : 0);

            players.clear();
        }

        return answer;
    }

    private boolean outOfBound(int x, int y) {
        if (x >= 0 && x < 5 && y >= 0 && y < 5) {
            return false;
        }
        return true;
    }

    private boolean[] clearVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return visited;
    }

}

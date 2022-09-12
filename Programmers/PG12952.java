public class PG12952 {

    public int[][] board;
    public int answer;

    public int solution(int n) {
        board = new int[n][n];
        answer = 0;

        recursion(new boolean[n], 0);

        return answer;
    }

    public void recursion(boolean[] visited, int idx) {
        if (idx == visited.length) {
            answer++;
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && isPossible(idx, i)) {
                board[idx][i] = 1; // Q
                visited[i] = true;
                recursion(visited, idx + 1);
                board[idx][i] = 0;
                visited[i] = false;
            }
        }
    }

    public boolean isPossible(int a, int b) {
        int x = a, y = b;
        while (x >= 0 && y >= 0) {
            if (board[x--][y--] == 1) {
                return false;
            }
        }

        x = a;
        y = b;
        while (x >= 0 && y < board.length) {
            if (board[x--][y++] == 1) {
                return false;
            }
        }

        return true;
    }

}
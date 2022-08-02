public class PG12905 {

    public int row, column;

    public int solution(int[][] board) {
        row = board.length;
        column = board[0].length;
        int[][] dp = new int[row][column];
        int answer = 0;

        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
        }
        for (int i = 0; i < column; i++) {
            dp[0][i] = board[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                dp[i][j] = board[i][j];

                if (outOfBound(i, j - 1) || board[i][j - 1] == 0) { // 왼쪽
                    continue;
                }
                if (outOfBound(i - 1, j) || board[i - 1][j] == 0) { // 위쪽
                    continue;
                }
                if (outOfBound(i - 1, j - 1) || board[i - 1][j - 1] == 0) { // 왼쪽 위 대각선
                    continue;
                }

                /*
                 * (왼쪽 위 대각선) + 1하면 X, (세 곳 중 최솟값) + 1이 중요함!
                 * 반례)
                 * 1 1 0
                 * 1 1 1
                 * 0 1 1
                 */
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer * answer;
    }

    public boolean outOfBound(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < column) {
            return false;
        }
        return true;
    }

}
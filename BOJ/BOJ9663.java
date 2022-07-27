import java.io.*;
import java.util.Arrays;

public class BOJ9663 {

    public static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] board = new int[n];
        Arrays.fill(board, -1);
        result = 0;

        solve(board, 0);

        System.out.println(result);
    }

    public static void solve(int[] board, int x) {
        if (x == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (board[i] >= 0 || !check(board, x, i)) {
                continue;
            }
            board[i] = x;
            solve(board, x + 1);
            board[i] = -1;
        }
    }

    public static boolean check(int[] board, int x, int y) {
        for (int i = 0; i < n; i++) {
            if (x == board[i] || board[i] < 0) {
                continue;
            }
            if (Math.abs(x - board[i]) == Math.abs(y - i)) {
                return false;
            }
        }
        return true;
    }

}
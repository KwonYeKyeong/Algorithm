public class Problem1 {

    public int solution(int money, int[] costs) {
        final int[] value = {0, 1, 5, 10, 50, 100, 500};
        int[][] result = new int[7][money + 1];

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j <= money; j++) {
                if (i == 0) {
                    result[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (j == 0) {
                    result[i][j] = 0;
                    continue;
                }
                if (j >= value[i]) {
                    result[i][j] = Math.min(result[i - 1][j], result[i][j-value[i]] + costs[i-1]);
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }

        return result[6][money];
    }

}
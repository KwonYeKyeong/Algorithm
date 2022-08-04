public class PG12949 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int column = arr2[0].length;
        int[][] answer = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }

        return answer;
    }

}
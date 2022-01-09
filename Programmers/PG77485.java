import java.util.*;

public class PG77485 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int[][] rotationMatrix = new int[rows][columns];
            int min = rows * columns;
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < columns; y++) {
                    if (x == x1 && (y >= y1 && y <= y2) || x == x2 && (y >= y1 && y <= y2)
                            || y == y1 && (x >= x1 && x <= x2) || y == y2 && (x >= x1 && x <= x2)) {
                        if (x == x1 && (y > y1 && y <= y2)) {
                            rotationMatrix[x][y] = matrix[x][y - 1];
                        }
                        if (x == x2 && (y >= y1 && y < y2)) {
                            rotationMatrix[x][y] = matrix[x][y + 1];
                        }
                        if (y == y1 && (x >= x1 && x < x2)) {
                            rotationMatrix[x][y] = matrix[x + 1][y];
                        }
                        if (y == y2 && (x > x1 && x <= x2)) {
                            rotationMatrix[x][y] = matrix[x - 1][y];
                        }

                        min = min > rotationMatrix[x][y] ? rotationMatrix[x][y] : min;
                    } else {
                        rotationMatrix[x][y] = matrix[x][y];
                    }
                }
            }

            answer.add(min);
            matrix = rotationMatrix;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

}

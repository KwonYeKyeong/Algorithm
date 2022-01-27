public class PG60059 {

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = lock.length;
        int m = key.length;

        // line 9 ~ 19 : lock이 모두 1인 경우 => key 필요없음(= 항상 true)
        boolean pass = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] == 0) {
                    pass = false;
                }
            }
        }
        if (pass) {
            return answer = true;
        }

        int[][] extendedKey = new int[2 * n + m - 2][2 * n + m - 2]; // 확장한 key
        int[][] rotatedKey = new int[m][m];

        int attempt = 0;
        while (attempt++ < 4 && !answer) {
            // 시계방향으로 90도 회전
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    rotatedKey[j][m - 1 - i] = key[i][j];
                }
            }
            key = copy(rotatedKey, key);

            for (int i = 0; i < extendedKey.length; i++) {
                for (int j = 0; j < extendedKey.length; j++) {
                    if (i >= n - 1 && i <= n + m - 2
                            && j >= n - 1 && j <= n + m - 2) {
                        extendedKey[i][j] = rotatedKey[i - (n - 1)][j - (n - 1)];
                    } else {
                        extendedKey[i][j] = 0;
                    }
                }
            }

            for (int x = 0; x < n + m - 1; x++) {
                for (int y = 0; y < n + m - 1; y++) {

                    boolean check = match(x, y, extendedKey, lock);

                    if (check) {
                        answer = check;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public boolean match(int x, int y, int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (key[x + i][y + j] + lock[i][j] == 1) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] copy(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }

}

public class Problem2 {

    public int[][] solution(int n, boolean clockwise) {
        int[][] clockDir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] counterClockDir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int[][] clockPoint = { { 0, 0 }, { 0, n - 1 }, { n - 1, n - 1 }, { n - 1, 0 } };
        int[][] counterClockPoint = { { 0, 0 }, { n - 1, 0 }, { n - 1, n - 1 }, { 0, n - 1 } };

        int[][] answer = new int[n][n];
        if (clockwise) { // 시계방향
            for (int i = 0; i < 4; i++) {
                int box = 1, minus = n - 1, dir = i;
                int curX = clockPoint[i][0];
                int curY = clockPoint[i][1];
                while (true) {
                    for (int step = 0; step < minus; step++) {
                        answer[curX][curY] = box++;
                        curX += clockDir[dir][0];
                        curY += clockDir[dir][1];
                    }
                    if (minus <= 1) {
                        break;
                    }
                    minus = (minus - 2) == 0 ? 1 : minus - 2;
                    curX -= clockDir[dir][0];
                    curY -= clockDir[dir][1];
                    dir = (dir + 1) % 4;
                    curX += clockDir[dir][0];
                    curY += clockDir[dir][1];
                }
            }
        } else { // 반시계방향
            for (int i = 0; i < 4; i++) {
                int box = 1, minus = n - 1, dir = i;
                int curX = counterClockPoint[i][0];
                int curY = counterClockPoint[i][1];
                while (true) {
                    for (int step = 0; step < minus; step++) {
                        answer[curX][curY] = box++;
                        curX += counterClockDir[dir][0];
                        curY += counterClockDir[dir][1];
                    }
                    if (minus <= 1) {
                        break;
                    }
                    minus = (minus - 2) == 0 ? 1 : minus - 2;
                    curX -= counterClockDir[dir][0];
                    curY -= counterClockDir[dir][1];
                    dir = (dir + 1) % 4;
                    curX += counterClockDir[dir][0];
                    curY += counterClockDir[dir][1];
                }
            }
        }

        return answer;
    }

}
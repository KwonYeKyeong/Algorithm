public class PG92342 {
    public int[] answer = { -1 };
    public int gap = -1;

    public int[] solution(int n, int[] info) {
        shoot(info, new int[11], n, 10);

        return answer;
    }

    public void shoot(int[] info, int[] rion, int arrowsLeft, int point) {
        if (point == 0) {
            rion[10 - point] = arrowsLeft;

            int rionMinusApeach = calculatePoint(info, rion);
            if (rionMinusApeach > 0) {
                if (gap < rionMinusApeach || (gap == rionMinusApeach && hasLowerPoints(answer, rion))) {
                    gap = rionMinusApeach;
                    answer = rion.clone();
                }
            }

            return;
        }

        if (arrowsLeft > info[10 - point]) {
            rion[10 - point] = info[10 - point] + 1;
            shoot(info, rion, arrowsLeft - rion[10 - point], point - 1);
        }
        if (arrowsLeft >= info[10 - point]) {
            rion[10 - point] = info[10 - point];
            shoot(info, rion, arrowsLeft - rion[10 - point], point - 1);
        }
        if (info[10 - point] != 0) {
            rion[10 - point] = 0;
            shoot(info, rion, arrowsLeft, point - 1);
        }
    }

    public int calculatePoint(int[] info, int[] rion) {
        int rionPoint = 0, apeachPoint = 0;
        for (int i = 0; i <= 10; i++) {
            if (info[i] != 0 && info[i] >= rion[i]) {
                apeachPoint += (10 - i);
            } else if (info[i] < rion[i]) {
                rionPoint += (10 - i);
            }
        }
        return rionPoint - apeachPoint;
    }

    public boolean hasLowerPoints(int[] answer, int[] rion) {
        for (int i = 10; i >= 0; i--) {
            if (answer[i] < rion[i]) {
                return true;
            }
            if (answer[i] > rion[i]) {
                return false;
            }
        }
        return false;
    }
}
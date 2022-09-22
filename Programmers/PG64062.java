public class PG64062 {

    public int solution(int[] stones, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            left = Math.min(left, stones[i]);
            right = Math.max(right, stones[i]);
        }

        while (left <= right) {
            int[] copy_stones = stones.clone();
            int mid = (left + right) / 2;

            int cnt = 0;
            boolean check = false;
            for (int i = 0; i < stones.length; i++) {
                copy_stones[i] = copy_stones[i] <= mid ? 0 : (copy_stones[i] - mid);

                if (copy_stones[i] > 0) {
                    cnt = 0;
                    continue;
                }
                if (++cnt >= k) {
                    right = mid - 1;
                    check = true;
                    break;
                }
            }

            if (check) {
                continue;
            }
            left = mid + 1;
        }

        return left;
    }

}
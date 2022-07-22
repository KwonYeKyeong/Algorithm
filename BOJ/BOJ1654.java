import java.io.*;

public class BOJ1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int k = Integer.parseInt(nk[0]);
        int n = Integer.parseInt(nk[1]);

        int[] num = new int[k];
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            num[i] = Integer.parseInt(br.readLine());
            maxNum = maxNum < num[i] ? num[i] : maxNum;
        }

        long l = 1, r = maxNum;
        while (l <= r) {
            long mid = (l + r) / 2;

            int cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += num[i] / mid;
            }

            if (cnt >= n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(r);
    }

}

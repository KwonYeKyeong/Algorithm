import java.io.*;
import java.util.*;

public class BOJ11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while (st.hasMoreTokens()) {
            A[idx++] = Integer.parseInt(st.nextToken());
        }

        // 1) Arrays.sort() 이용
        // Arrays.sort(A); // 평균 : nlogn, 최악 : n^2

        // 2) quick selection sort -> 미완성
        quick_selection_sort(A, 0, n - 1, k - 1);

        System.out.println(A[k - 1]);
    }

    public static void quick_selection_sort(int[] A, int s, int e, int k) {
        if (s >= e) {
            return;
        }

        int pivot = s;
        int low = s + 1;
        int high = e;

        while (low <= high) {
            while (low <= e && A[low] <= A[pivot]) {
                low++;
            }
            while (high > s && A[high] >= A[pivot]) {
                high--;
            }

            if (low > high) {
                swap(A, pivot, high);
            } else {
                swap(A, low, high);
            }
        }

        if (high == k) {
            return;
        }
        if (high < k) {
            quick_selection_sort(A, high + 1, e, k);
        } else {
            quick_selection_sort(A, s, high - 1, k);
        }
    }

    public static void swap(int[] A, int l, int r) {
        int tmp = A[r];
        A[r] = A[l];
        A[l] = tmp;
    }

}

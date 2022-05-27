import java.io.*;
import java.util.*;

public class BOJ17298 {

    // 2) 자료구조 - 스택
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Stack<Integer> ans = new Stack<>();
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (st.empty()) {
                ans.push(-1);
            } else {
                while (!st.empty() && nums[i] >= st.peek()) {
                    st.pop();
                }
                if (st.empty()) {
                    ans.push(-1);
                } else {
                    ans.push(st.peek());
                }
            }
            st.push(nums[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!ans.empty()) {
            sb.append(ans.peek()).append(" ");
            ans.pop();
        }

        System.out.println(sb.toString());
    }

    // 1) 이분탐색 - 시간초과
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     int n = Integer.parseInt(br.readLine());
    //     int[] nums = Arrays.stream(br.readLine().split(" "))
    //             .mapToInt(Integer::parseInt).toArray();

    //     int[] answer = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         answer[i] = binarySearch(nums, i);
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     for (int a : answer) {
    //         sb.append(a).append(' ');
    //     }

    //     System.out.println(sb.toString());
    // }

    // public static int binarySearch(int[] nums, int startIdx) {
    //     int[] sortedNums = new int[nums.length - (startIdx + 1)];
    //     for (int i = 0; i < sortedNums.length; i++) {
    //         sortedNums[i] = nums[startIdx + i + 1];
    //     }

    //     Arrays.sort(sortedNums);

    //     int left = 0, right = sortedNums.length - 1;
    //     int target = nums[startIdx];
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         if (sortedNums[mid] <= target) {
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //     }
    //     return left >= sortedNums.length ? -1 : sortedNums[left];
    // }

}
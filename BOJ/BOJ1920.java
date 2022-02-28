import java.io.*;
import java.util.*;

public class BOJ1920 {

    // 1) 자료 구조(Set) 사용
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     int n = Integer.parseInt(br.readLine());
    //     String[] A = br.readLine().split(" ");
    //     Set<String> set = new HashSet<>();
    //     for (int i = 0; i < A.length; i++) {
    //         set.add(A[i]);
    //     }

    //     int m = Integer.parseInt(br.readLine());
    //     String[] nums = br.readLine().split(" ");
    //     for (int i = 0; i < nums.length; i++) {
    //         if (set.contains(nums[i])) {
    //             System.out.println(1);
    //         } else {
    //             System.out.println(0);
    //         }
    //     }
    // }

    // 2) 이분 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputNumbers = br.readLine().split(" ");
        int[] A = Arrays.stream(inputNumbers).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        String[] findNumbers = br.readLine().split(" ");
        int[] M = Arrays.stream(findNumbers).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);

        boolean print = false;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1, mid;
            int target = M[i];
            print = false;
            while (left <= right) {
                mid = (left + right) / 2;
                if (A[mid] == target) {
                    System.out.println(1);
                    print = true;
                    break;
                } else if (A[mid] < target) {
                    left = mid + 1;
                } else if (A[mid] > target) {
                    right = mid - 1;
                }
            }
            if (!print) {
                System.out.println(0);
            }
        }
    }

}
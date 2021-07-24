/*
문제 : 크기가 N x N인 배열 A가 있다. 배열에 들어있는 수 A[i][j] = i x j이다. 이 수를 배열 B에 넣었고 오름차순 정렬을 했을 때, B[k]를 구해보자.
알고리즘 : 이분 탐색
풀이 : 임의의 값 m(mid)을 정하고 m보다 작은 수의 개수(cnt)를 센다 = m이 (cnt + 1)번째 수라는 뜻.
       그래서 (cnt + 1)이 k보다 크면 m의 값을 줄이고 k보다 작으면 m의 값을 늘려간다. -> 이분 탐색 알고리즘 이용
*/

import java.io.*;

public class BOJ1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1, right = n*n, mid; // right = k으로 초기화 하는 이유? k번째 수가 k보다 클 수 없다.
        int result = 0;
        while(left<=right){
            mid = (left + right) / 2;

            int cnt = 0;
            for(int i=1;i<=n;i++)
                cnt += Math.min(mid/i, n); // i*j <= mid

            if(cnt >= k){
                result = mid;
                right = mid - 1;
            }
            else 
                left = mid + 1;
        }

        System.out.println(result);
    }
}

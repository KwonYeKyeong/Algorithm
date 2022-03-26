public class Problem4 {

    public int solution(int[] arr, int[] brr) {
        int answer = 0;

        int task = arr.length / 2;
        if (arr.length % 2 != 0) {
            task++;
        }

        for (int i = 0; i < task; i++) {
            if (arr[i] != brr[i]) {
                arr[i+1] += arr[i]-brr[i];
                arr[i] = brr[i];
                answer++;
            }
            if (arr[arr.length - (i + 1)] != brr[brr.length - (i + 1)]) {
                arr[arr.length - (i + 2)] += arr[arr.length - (i + 1)]-brr[brr.length - (i + 1)];
                arr[arr.length - (i + 1)] = brr[brr.length - (i + 1)];
                answer++;
            }
        }

        return answer;
    }

}

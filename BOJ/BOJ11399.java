import java.io.*;
import java.util.*;

public class BOJ11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] time = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(time);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += time[i] * (n - i);
        }
        System.out.println(answer);
    }

}
import java.io.*;

public class BOJ1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        int answer = 0;
        while (a >= b) {
            a %= b;
        }
        while (n-- > 0) {
            answer = a * 10 / b;
            a = (a * 10) % b;
        }

        System.out.println(answer);
    }
}

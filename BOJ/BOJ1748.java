import java.io.*;

public class BOJ1748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int tens = 10, place = 1, answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i < tens) {
                answer += place;
            } else {
                tens *= 10;
                place++;
                i--;
            }
        }

        System.out.println(answer);
    }
    
}
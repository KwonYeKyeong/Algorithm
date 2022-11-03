import java.io.*;

public class BOJ19844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = br.readLine().replace('-', ' ').split(" ");
        String regex = "(c|j|n|m|t|s|l|d|qu)(')[aeiouh].*";
        int cnt = words.length;
        for (String word : words) {
            if (word.matches(regex)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}

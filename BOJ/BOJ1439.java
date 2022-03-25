import java.io.*;

public class BOJ1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] cnt = new int[2];
        char cur = s.charAt(0);
        cnt[cur - '0']++;
        for (int i = 1; i < s.length(); i++) {
            if(cur != s.charAt(i)){
                cur = s.charAt(i);
                cnt[cur-'0']++;
            }
        } 
        
        System.out.println(Math.min(cnt[0], cnt[1]));
    }

}
import java.io.*;
import java.util.*;

public class BOJ5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneBook = new String[n];
            for (int i = 0; i < n; i++) {
                phoneBook[i] = br.readLine();
            }

            Arrays.sort(phoneBook);

            boolean isConsistent = true;
            for (int i = 0; i < n - 1; i++) {
                if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                    isConsistent = false;
                    break;
                }
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }

}

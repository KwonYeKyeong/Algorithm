import java.io.*;
import java.util.Stack;

public class BOJ17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> st = new Stack<>();
        boolean check = false;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                check = true;
                sb.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == '>') {
                check = false;
                sb.append(s.charAt(i));
                continue;
            }
            if (check) {
                sb.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ' ') {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                sb.append(s.charAt(i));
                continue;
            }
            st.push(s.charAt(i));
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.println(sb.toString());
    }
}

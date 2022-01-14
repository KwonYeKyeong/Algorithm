import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> st = new Stack<>();
        boolean impossible = false;
        int result = 0;
        int save = 1;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> {
                    save *= 2;
                    st.add('(');
                }
                case ')' -> {
                    if (st.empty() || st.peek() != '(') {
                        impossible = true;
                        break;
                    }

                    if (s.charAt(i - 1) == '(') {
                        result += save;
                    }
                    save /= 2;
                    st.pop();
                }
                case '[' -> {
                    save *= 3;
                    st.add('[');
                }
                case ']' -> {
                    if (st.empty() || st.peek() != '[') {
                        impossible = true;
                        break;
                    }

                    if (s.charAt(i - 1) == '[') {
                        result += save;
                    }
                    save /= 3;
                    st.pop();
                }
            }
        }

        if (impossible || !st.empty()) {
            result = 0;
        }

        System.out.println(result);
    }

}

import java.util.Stack;

public class PG12973 {

    // 그냥 구현 시, 효율성 테스트 미통과(시간초과)

    public int solution(String s) {
        Stack<Character> st = new Stack<>();

        st.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
                continue;
            }
            st.add(s.charAt(i));
        }

        return st.isEmpty() ? 1 : 0;
    }

}
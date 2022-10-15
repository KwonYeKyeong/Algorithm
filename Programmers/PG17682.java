import java.util.*;

import java.util.regex.Pattern; // 따로따로 import해야함
import java.util.regex.Matcher;

public class PG17682 {

    public int solution(String dartResult) {
        int answer = 0;

        Pattern pattern = Pattern.compile("(\\d+)([SDT])([*#]?)"); // ([0-9]+)([SDT])([*#]?)
        Matcher matcher = pattern.matcher(dartResult);

        Map<String, Integer> map = new HashMap<>() {
            {
                put("S", 1);
                put("D", 2);
                put("T", 3);
            }
        };

        Stack<Integer> st = new Stack<>();
        while (matcher.find()) {
            int n = Integer.parseInt(matcher.group(1));
            String sdt = matcher.group(2);
            int point = (int) Math.pow(n, map.get(sdt));

            if (matcher.group(3).equals("*")) {
                if (!st.isEmpty()) {
                    int prev = st.pop();
                    st.push(prev * 2);
                }
                point *= 2;
            } else if (matcher.group(3).equals("#")) {
                point *= (-1);
            }

            st.push(point);
        }

        while (!st.isEmpty()) {
            answer += st.pop();
        }

        return answer;
    }

}

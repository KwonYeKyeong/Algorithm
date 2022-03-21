import java.util.*;

public class PG60058 {

    public String solution(String p) {
        return recursiveCall(p);
    }

    public String recursiveCall(String p) {
        if (p.length() > 0) {
            int openParenthesis = 0, closedParenthesis = 0;
            for (int i = 0; i < p.length(); i++) {
                switch (p.charAt(i)) {
                    case '(' -> openParenthesis++;
                    case ')' -> closedParenthesis++;
                }

                if (openParenthesis == closedParenthesis) {
                    String u = p.substring(0, i + 1);
                    String v = p.substring(i + 1, p.length());
                    if (isCorrectString(u)) {
                        return u + recursiveCall(v);
                    } else {
                        String o = oppositeString(p.substring(1, i));
                        return "(" + recursiveCall(p.substring(i + 1, p.length())) + ")" + o;
                    }
                }
            }
        }

        return p;
    }

    public boolean isCorrectString(String u) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            switch (u.charAt(i)) {
                case '(' -> stack.push('(');
                case ')' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public String oppositeString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> sb.append(")");
                case ')' -> sb.append("(");
            }
        }

        return sb.toString();
    }

}
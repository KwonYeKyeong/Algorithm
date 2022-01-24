import java.util.*;

public class PG67257 {

    public static char[] operators = { '+', '-', '*' };
    public static List<Long> numList;
    public static List<Character> operList;
    public static long answer;

    public long solution(String expression) {
        numList = new ArrayList<>();
        operList = new ArrayList<>();
        answer = 0;

        StringBuilder number = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                numList.add(Long.parseLong(number.toString()));
                number = new StringBuilder();
                operList.add(expression.charAt(i));
            } else {
                number.append(expression.charAt(i));
            }
        }
        numList.add(Long.parseLong(number.toString()));

        setOperatorPriority(new ArrayList<Character>(), new boolean[3]);

        return answer;
    }

    public void setOperatorPriority(List<Character> operPriorityList, boolean[] visited) {
        if (operPriorityList.size() == 3) {
            answer = answer < Math.abs(calculateExpression(operPriorityList))
                    ? Math.abs(calculateExpression(operPriorityList))
                    : answer;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                operPriorityList.add(operators[i]);
                setOperatorPriority(operPriorityList, visited);
                visited[i] = false;
                operPriorityList.remove(Character.valueOf(operators[i]));
            }
        }
    }

    public long calculateExpression(List<Character> operPriorityList) {
        List<Long> tmpNumList = new ArrayList<>();
        numList.forEach(n -> tmpNumList.add(n));
        List<Character> tmpOperList = new ArrayList<>();
        operList.forEach(o -> tmpOperList.add(o));

        for (char priority : operPriorityList) {
            for (int index = 0; index < tmpOperList.size(); index++) {
                if (tmpOperList.get(index) == priority) {
                    long a = tmpNumList.get(index);
                    long b = tmpNumList.get(index + 1);
                    tmpNumList.add(index, calculate(a, b, tmpOperList.get(index)));
                    tmpOperList.remove(index);
                    tmpNumList.remove(index + 1);
                    tmpNumList.remove(index + 1);
                    index--;
                }
            }
        }

        return tmpNumList.get(0);
    }

    public long calculate(long a, long b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> throw new IllegalArgumentException("Unexpected value: " + operator);
        };
    }

}

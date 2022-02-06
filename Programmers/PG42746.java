import java.util.*;

public class PG42746 {

    public String solution(int[] numbers) {
        String[] numbersToString = Arrays.stream(numbers)
                .mapToObj(number -> String.valueOf(number))
                .toArray(String[]::new);

        Arrays.sort(numbersToString, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbersToString.length; i++) {
            if (numbersToString[0].equals("0")) {
                sb.append("0");
                break;
            }
            sb.append(numbersToString[i]);
        }

        return sb.toString();
    }

}

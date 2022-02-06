import java.util.*;

public class PG12939 {

    public String solution(String s) {
        String[] numbers = s.split(" ");
        int[] array = Arrays.stream(numbers)
                .mapToInt(number -> Integer.parseInt(number))
                .toArray();

        Arrays.sort(array); // 오름차순 정렬

        String answer = array[0] + " " + array[array.length - 1];

        return answer;
    }

}

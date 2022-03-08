import java.util.*;

public class PG42842 {

    public int[] solution(int brown, int yellow) {
        Integer[] answer = new Integer[2];

        int yellowWidth = 0, yellowDepth;
        while (yellowWidth++ < yellow) {
            if (yellow % yellowWidth != 0) {
                continue;
            }

            yellowDepth = yellow / yellowWidth;
            if (2 * (yellowDepth + yellowWidth) + 4 == brown) {
                answer[0] = yellowWidth + 2;
                answer[1] = yellowDepth + 2;
                break;
            }
        }

        Arrays.sort(answer, Collections.reverseOrder());
        int[] desc = Arrays.stream(answer).mapToInt(i -> i).toArray();

        return desc;
    }

}
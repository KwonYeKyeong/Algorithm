import java.util.*; 

public class PG42747 {
    
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0, h = 0;
        while (true) {
            int idx = 0;
            while (citations.length > idx && citations[idx] < h) {
                idx++;
            }
            if (h > citations.length - idx) {
                answer = h - 1;
                break;
            } else {
                h++;
            }
        }
        return answer;
    }

}

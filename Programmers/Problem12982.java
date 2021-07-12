// 예산

import java.util.Arrays;

class Solution_12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d); // 오름차순 정렬
        
        for(int i=0;i<d.length;i++){
            if(budget>=d[i]){
                budget-=d[i];
                answer++;
            }
        }

        return answer;
    }
}

public class Problem12982{
    public static void main(String[] args) {
        Solution_12982 s = new Solution_12982();

        int[] d = {2,2,3,3};
        int budget = 10;

        s.solution(d, budget);
    }
} 

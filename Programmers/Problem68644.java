// 두 개 뽑아서 더하기

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Comparator;

class Solution_68644 {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int value=numbers[i]+numbers[j];
                if(list.indexOf(value)<0)
                    list.add(value);
            }
        }

        list.sort(Comparator.naturalOrder());

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++)
            answer[i] = list.get(i);

        // Arrays.sort(answer);

        return answer;
    }
}

public class Problem68644 {
    public static void main(String args[]){
        Solution_68644 s = new Solution_68644();

        int[] answer = {2,1,3,4,1};

        s.solution(answer);
    }
}



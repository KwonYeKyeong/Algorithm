// 영어 끝말잇기

import java.util.ArrayList;

class Solution_12981 {
    public int[] solution(int n, String[] words) {
        ArrayList<String> wordList = new ArrayList<String>();
        int[] answer = new int[2];
        int num = -1, turn = 1;

        wordList.add(words[0]);
        String lastWord = words[0];
        for(int i=1;i<words.length;i++){
            if(lastWord.charAt(lastWord.length()-1) == words[i].charAt(0)
                && wordList.indexOf(words[i])<0){
                wordList.add(words[i]);
                lastWord = words[i];
            }
            else{
                num = i%n + 1;
                break;
            }

            if(i%n==n-1)
                turn++;
        }

        if(num == -1){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = num;
            answer[1] = turn;
        }
        return answer;
    }
}
public class Problem12981 {
    public static void main(String[] args) {
        Solution_12981 s = new Solution_12981();

        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        s.solution(n, words);
    }
}

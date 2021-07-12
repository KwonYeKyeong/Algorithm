// 후보키
/*
문제 : 관계 데이터베이스에서 릴레이션(Relation)의 튜플(Tuple)을 유일하게 식별할 수 있는 속성(Attribute) 또는 속성의 집합 중
       유일성과 최소성을 만족하는 후보 키(Candidate Key)의 최대 개수 구하기
알고리즘 : 비트마스킹
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution_42890 {
    ArrayList<Integer> candidateKey;
    int rowLen, colLen;

    public int solution(String[][] relation) {
        candidateKey = new ArrayList<>();
        rowLen = relation.length;
        colLen = relation[0].length;
        int answer = 0;

        for(int set=1;set<(1<<colLen);set++){ // 모든 조합 구하기(0001 ~ 1111)
            // 최소성 검사
            if(!isMinimal(set)) continue;

            // 유일성 검사
            if(isUnique(set, relation))
                candidateKey.add(set);
        }

        answer = candidateKey.size();

        return answer;
    }
    private boolean isMinimal(int set){ 
        for(int key : candidateKey){
            if((key & set)==key) // 포함 관계 구하기
                return false;
        }
        return true;
    }
    private boolean isUnique(int set, String[][] relation){ 
        Map<String, String> map = new HashMap<>();

        for(int r=0;r<rowLen;r++){
            String str = "";
            for(int c=0;c<colLen;c++){ // 자릿수 구하기
                if((set&(1<<c))!=0)
                    str+=relation[r][c];
            }

            if(map.containsKey(str))
                return false;
            else map.put(str, str);
        }

        return true;
    }
}
public class Problem42890 {
    public static void main(String[] args) {
        Solution_42890 s = new Solution_42890();

        String[][] relation = {{"100","ryan","music","2"}, {"200","apeach","math","2"}, {"300","tube","computer","3"}, 
                                {"400","con","computer","4"}, {"500","muzi","music","3"}, {"600","apeach","music","2"}};

        s.solution(relation);
    }
}

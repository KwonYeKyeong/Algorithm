// 캐시

import java.util.ArrayList;

class Solution_17680 {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> list = new ArrayList<>();
        int answer = 0; // 총 실행시간

        if(cacheSize==0)
            answer = cities.length*5;
        else{
            for(int i=0;i<cities.length;i++){
                String city = cities[i].toUpperCase();

                if(list.size()<cacheSize){
                    list.add(city);
                    answer+=5;
                }
                else{
                    if(list.indexOf(city)<0){ // 캐쉬에 해당 도시 이름이 존재하지 않을 때
                        list.remove(0);
                        answer+=5; // cache miss 실행시간 : 5
                    }
                    else{
                        list.remove(list.indexOf(city));
                        answer+=1; // cache hit 실행시간 : 1
                    }
                    list.add(city);
                
                }
            }
        }
        
        return answer;
    }
}
public class Problem17680 {
    public static void main(String[] args) {
        Solution_17680 s = new Solution_17680();

        int cacheSize = 2;
        String[] cities ={"Jeju", "Pangyo", "NewYork", "newyork"};

        s.solution(cacheSize, cities);
    }
}

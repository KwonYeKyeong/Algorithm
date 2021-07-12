// 방금그곡
/*
문제 : 라디오에서 나왔던 멜로디를 기억할 때 그 멜로디와 일치하는 음악 제목을 반환하기
조건 : 조건이 일치하는 음악이 여러 개일 경우; 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환
       재생된 시간도 같을 경우; 먼저 입력된 음악 제목 반환
       조건이 일치하는 음악이 없을 경우; (None) 반환
구현 시 주의사항 : 악보에 사용되는 음 중 #이 붙은 음계가 존재하기 때문에(C#, D#, F#, G#, A#)
                  이 음계를 소문자로 변환하여 취급하는 것이 구현에 도움이 됨
*/

class Solution_17683 {
    public String solution(String m, String[] musicinfos) {
        final char[] note = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        String answer = "";
        int len = 0;

        for(String info : musicinfos){
            String[] i = info.split(",");

            String start = i[0];
            int startH = Integer.parseInt(start.substring(0, 2));
            int startM = Integer.parseInt(start.substring(3, 5));
            String end = i[1];
            int endH = Integer.parseInt(end.substring(0, 2));
            int endM = Integer.parseInt(end.substring(3, 5));
            int musicLen = (endH-startH)*60+endM-startM; // 라디오에서 재생된 시간
            String title = i[2];
            String melody = i[3];
            for(int j=0;j<melody.length();j++){ // #붙은 음계 소문자로 바꿔주기 ex) C# -> c
                if(melody.charAt(j)=='#'){
                    String tmpMelody = melody.substring(0, j-1);
                    tmpMelody += note[melody.charAt(j-1)-'A'];
                    melody = tmpMelody + melody.substring(j+1);
                    j--;
                }
            }
            String totalMelody = ""; // 라디오에서 실제로 재생된 음악멜로디
            if(musicLen<melody.length())
                totalMelody = melody.substring(0, musicLen);
            else{
                for(int j=0;j<(musicLen/melody.length());j++)
                    totalMelody+=melody;
                totalMelody+=melody.substring(0, (musicLen%melody.length()));
            }

            for(int j=0;j<m.length();j++){ // #붙은 음계 소문자로 바꿔주기 ex) C# -> c
                if(m.charAt(j)=='#'){
                    String tmpMelody = m.substring(0, j-1);
                    tmpMelody += note[m.charAt(j-1)-'A'];
                    m = tmpMelody + m.substring(j+1);
                    j--;
                }
            }
            if(totalMelody.contains(m)){
                if(len<musicLen){
                    len = musicLen;
                    answer = title;
                }
            }
        }

        if(answer.equals(""))
            answer = "(None)";
        return answer;
    }
}
public class Problem17683 {
    public static void main(String[] args) {
        Solution_17683 s = new Solution_17683();

        String m = "A#";
        String[] musicinfos = {"13:00,13:02,HAPPY,B#A#"};

        s.solution(m, musicinfos);
    }
}

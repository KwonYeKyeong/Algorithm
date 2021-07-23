import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4659 {
    public static void main(String[] args) throws IOException {
        final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String password = br.readLine();

            if(password.equals("end")) break;

            boolean acceptable = true;
            boolean containVowels = false;
            int cntVowels = 0; // 모음 개수
            int cntConsonants = 0; // 자음 개수
            char last = '0'; // 이전 문자

            for(int i=0;i<password.length();i++){
                // 조건 1
                boolean isVowels = false;
                for(char v : VOWELS){
                    if(v == password.charAt(i)){
                        isVowels = true;
                        containVowels = true;
                        break;
                    }
                }
                if(isVowels){
                    cntVowels++;
                    cntConsonants = 0;
                }
                else{
                    cntVowels = 0;
                    cntConsonants++;
                }

                // 조건 2
                if(cntVowels>=3 || cntConsonants>=3)
                    acceptable = false;
                
                // 조건 3
                if(password.charAt(i)!='e' && password.charAt(i)!='o' && password.charAt(i)==last)
                    acceptable = false;
                
                last = password.charAt(i);

                if(!acceptable || (i==password.length()-1 && !containVowels)){
                    System.out.println("<" + password + "> is not acceptable.");
                    break;
                }
                if(i==password.length()-1)
                    System.out.println("<" + password + "> is acceptable.");
            }
        }
    }
}

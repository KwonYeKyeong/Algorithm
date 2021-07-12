import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String answer = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='M'
                || str.charAt(i)>='a' && str.charAt(i)<='m')
                answer += (char)(str.charAt(i) + 13);
            else if(str.charAt(i)>='N' && str.charAt(i)<='Z'
                || str.charAt(i)>='n' && str.charAt(i)<='z')
                answer += (char)(str.charAt(i) - 13);
            else answer += str.charAt(i);
        }

        System.out.println(answer);
    }
}

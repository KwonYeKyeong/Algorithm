import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int number = 665;
        int movieTitle = number;
        while(n > 0){
            if(String.valueOf(++number).contains("666")){
                movieTitle = number;
                n--;
            }
        }

        System.out.println(movieTitle);
    }

}

import java.io.*;
import java.util.*;

public class BOJ1018 {
    public static void main(String[] args) throws IOException {
        final int CHESS = 8;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] board = new String[n];

        for(int i=0;i<n;i++)   
            board[i] = br.readLine();

        int min = 987654321;
        for(int i=0;i<=n-CHESS;i++){
            for(int j=0;j<=m-CHESS;j++){
                char color = 'B';
                int cnt = 0;
                for(int x=i;x<i+CHESS;x++){
                    for(int y=j;y<j+CHESS;y++){
                        if((x%2==i%2 && y%2==j%2) || (x%2!=i%2 && y%2!=j%2)){
                            if(color!=board[x].charAt(y))
                                cnt++;
                        }
                        else{
                            if(color==board[x].charAt(y))
                                cnt++;
                        }
                    }
                }

                min = Math.min(min, cnt);

                color = 'W';
                cnt = 0;
                for(int x=i;x<i+CHESS;x++){
                    for(int y=j;y<j+CHESS;y++){
                        if((x%2==i%2 && y%2==j%2) || (x%2!=i%2 && y%2!=j%2)){
                            if(color!=board[x].charAt(y))
                                cnt++;
                        }
                        else{
                            if(color==board[x].charAt(y))
                                cnt++;
                        }
                    }
                }

                min = Math.min(min, cnt);
            }
        }

        System.out.println(min);
    }
}

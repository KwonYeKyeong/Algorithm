import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ5549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        int[][] sumJ = new int[m+1][n+1];
        int[][] sumO = new int[m+1][n+1];
        int[][] sumI = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            String str = br.readLine();
            for(int j=1;j<=n;j++){
                switch(str.charAt(j-1)){
                    case 'J':
                        sumJ[i][j] = sumJ[i-1][j] + sumJ[i][j-1] - sumJ[i-1][j-1] + 1;
                        sumO[i][j] = sumO[i-1][j] + sumO[i][j-1] - sumO[i-1][j-1];
                        sumI[i][j] = sumI[i-1][j] + sumI[i][j-1] - sumI[i-1][j-1];
                        break;
                    case 'O':
                        sumJ[i][j] = sumJ[i-1][j] + sumJ[i][j-1] - sumJ[i-1][j-1];
                        sumO[i][j] = sumO[i-1][j] + sumO[i][j-1] - sumO[i-1][j-1] + 1;
                        sumI[i][j] = sumI[i-1][j] + sumI[i][j-1] - sumI[i-1][j-1];
                        break;
                    case 'I':
                        sumJ[i][j] = sumJ[i-1][j] + sumJ[i][j-1] - sumJ[i-1][j-1];
                        sumO[i][j] = sumO[i-1][j] + sumO[i][j-1] - sumO[i-1][j-1];
                        sumI[i][j] = sumI[i-1][j] + sumI[i][j-1] - sumI[i-1][j-1] + 1;
                }
            }
        }

        int x1, x2, y1, y2;
        while(k-->0){
            String[] str = br.readLine().split(" ");
            x1 = Integer.parseInt(str[0]);
            y1 = Integer.parseInt(str[1]);
            x2 = Integer.parseInt(str[2]);
            y2 = Integer.parseInt(str[3]);
            
            int cntJ = sumJ[x2][y2] - sumJ[x1-1][y2] - sumJ[x2][y1-1] + sumJ[x1-1][y1-1];
            bw.write(String.valueOf(cntJ));
            bw.write(" ");
            int cntO = sumO[x2][y2] - sumO[x1-1][y2] - sumO[x2][y1-1] + sumO[x1-1][y1-1];
            bw.write(String.valueOf(cntO));
            bw.write(" ");
            int cntI = sumI[x2][y2] - sumI[x1-1][y2] - sumI[x2][y1-1] + sumI[x1-1][y1-1];
            bw.write(String.valueOf(cntI));
            bw.write("\n");
            bw.flush();
        }
    }
}

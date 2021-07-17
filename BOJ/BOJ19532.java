import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] num = new int[6];
        int[] _num = new int[6];
        int x, y;

        String[] str = br.readLine().split(" ");
        for(int i=0;i<6;i++){
            num[i] = Integer.parseInt(str[i]);
            _num[i] = num[i];
        }
        
        for(int i=0;i<3;i++)
            num[i] *= _num[3];
        for(int i=3;i<6;i++)
            num[i] *= _num[0];

        y = (num[2]-num[5]) / (num[1]-num[4]);

        if(_num[0] != 0)
            x = (_num[2]-_num[1]*y) / _num[0];
        else
            x = (_num[5]-_num[4]*y) / _num[3];
        
        System.out.printf("%d %d", x, y);
    }
}
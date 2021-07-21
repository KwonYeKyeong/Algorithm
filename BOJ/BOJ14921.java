import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14921 {
    public static void main(String[] args) throws IOException {
        final int VALUE = 100000000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
    
        int b = VALUE;
        int start = 0; // 시작 인덱스
        int end = n-1; // 끝 인덱스
        while(start<end){
            int k = arr[start]+arr[end];
            if(k<0){
                if(Math.abs(k)<Math.abs(b))
                    b = k;
                start++;
            }
            else if(k>0){
                if(Math.abs(k)<Math.abs(b))
                    b = k;
                end--;
            }
            else{
                b = 0;
                break;
            }
        }

        System.out.print(b);
    }     
}

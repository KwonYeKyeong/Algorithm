import java.io.*;

public class BOJ17609 {
    static String s;
    static int p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            s = br.readLine();

            int left = 0, right = s.length()-1;
            p = Integer.MAX_VALUE;

            isPalindrome(left, right, 0);
            
            if(p<2)
                System.out.println(p);
            else System.out.println(2);
        }
    }
    public static void isPalindrome(int l, int r, int cnt){
        if(l>r) {
            p = (p<=cnt?p:cnt);
            return;
        }
        
        if(s.charAt(l)==s.charAt(r))
            isPalindrome(l+1, r-1, cnt);
        else{
            if(s.charAt(l+1)==s.charAt(r))
                isPalindrome(l+2, r-1, cnt+1);
            if(s.charAt(l)==s.charAt(r-1))
                isPalindrome(l+1, r-2, cnt+1);
        }
    }
}

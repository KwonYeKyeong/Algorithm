// 멀쩡한 사각형

import java.math.BigInteger;

class Solution_62048 {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = gcd(w, h);
        
        // for(int i=2;i<=w;i++){ // gcd 직접 구현 ver.
        //     if(w%i==0 && h%i==0){
        //         gcd = i;
        //     }
        // }
        
        answer = (long)w*(long)h-((long)w+(long)h-(long)gcd);
        
        return answer;
    }
    public int gcd(int a, int b){
        BigInteger aBigInteger = BigInteger.valueOf(a);
        BigInteger bBigInteger = BigInteger.valueOf(b);
        BigInteger gcdBigInteger = aBigInteger.gcd(bBigInteger);

        return gcdBigInteger.intValue();
    }
}
public class Problem62048 {
    public static void main(String[] args) {
        Solution_62048 s = new Solution_62048();

        int w = 8, h = 12;

        s.solution(w, h);
    }
}

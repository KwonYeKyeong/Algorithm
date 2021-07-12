// 내적

class Solution_70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int n = a.length;

        for(int i=0;i<n;i++)
            answer +=a[i]*b[i];
        
        return answer;
    }
}
public class Problem70128{
    public static void main(String[] args) {
        Solution_70128 s= new Solution_70128();

        int[] a = {-1,0,1};
        int[] b = {1,0,-1};

        s.solution(a, b);
    }
}
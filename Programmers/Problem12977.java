// 소수 만들기

class Solution_12977 {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int m=j+1;m<nums.length;m++){
                    if(isPrime(nums[i], nums[j], nums[m]))
                        answer++;
                }
            }
        }

        return answer;
    }
    public boolean isPrime(int a, int b, int c){ // 소수 판별 함수
        int sum = a+b+c;

        for(int i=2;i<sum;i++){
            if(sum%i==0) 
                return false;
        }
        
        return true;
    }
}
public class Problem12977{
    public static void main(String[] args) {
        Solution_12977 s= new Solution_12977();

        int[] nums={1,2,3,4};

        s.solution(nums);
    }
}
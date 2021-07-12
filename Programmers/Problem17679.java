// 프렌즈4블록

class Solution_17679 {
    static char [][] arr;
    static int M, N;
    public int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        arr = new char[M][N];
        int[][] dir = {{0, 1}, {1, 0}, {1, 1}};
        int answer = 0;
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++)
                arr[i][j] = board[i].charAt(j);
        }

        while(true){
            boolean[][] erased = new boolean[M][N];
            int cnt = 0;

            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    char block = arr[i][j];
                    boolean check = true;

                    if(block=='0') continue;

                    for(int d=0;d<3;d++){
                        int nextX = i+dir[d][0];
                        int nextY = j+dir[d][1];
                        if(!onBoard(nextX, nextY) || block != arr[nextX][nextY]){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        if(!erased[i][j]) {
                            cnt++;
                            erased[i][j] = true;
                        }
                        for(int d=0;d<3;d++){
                            int nextX = i+dir[d][0];
                            int nextY = j+dir[d][1];
                            if(onBoard(nextX, nextY) && !erased[nextX][nextY]){
                                cnt++;
                                erased[nextX][nextY] = true;
                            }
                        }
                    }
                }
            }
            
            if(cnt==0) break; // 더이상 지울 수 있는 블록이 없을 때
            answer += cnt;

            dropBlock(erased); 
        }

        return answer;
    }
    boolean onBoard(int x, int y){
        if(x>=0 && x<M && y>=0 && y<N)
            return true;
        return false;
    }
    void dropBlock(boolean erased[][]){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(erased[i][j]){ // 지워지는 블록이 있다면 위에 블록을 한칸씩 내림
                    for(int k=i;k>=0;k--){
                        if(k==0)
                            arr[k][j]='0';
                        else
                            arr[k][j]=arr[k-1][j];
                    }
                }
            }
        }
    }
}
public class Problem17679 {
    public static void main(String[] args) {
        Solution_17679 s = new Solution_17679();

        int m = 6, n = 2;
        String[] board = {"DD", "CC", "AA", "AA", "CC", "DD"};

        s.solution(m, n, board);
    }
}
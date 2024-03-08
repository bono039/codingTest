import java.util.*;

class Solution {
    static int[][] board, skill, sum;
    static int N, M;    
    
    public int solution(int[][] board, int[][] skill) {
        this.board = board;
        this.skill = skill;
        
        N = board.length;
        M = board[0].length;
        sum = new int[N+1][M+1];
        
        for(int[] s : skill) {   // 
            int type = s[0];
            int r1 = s[1]; int c1 = s[2];
            int r2 = s[3]; int c2 = s[4];
            int degree = s[5];
            
            if(type == 1) { // 적군
                sum[r1][c1] -= degree;
                sum[r1][c2 + 1] += degree;
                sum[r2 + 1][c1] += degree;
                sum[r2 + 1][c2 + 1] -= degree;
            }
            else {  // 아군
                sum[r1][c1] += degree;
                sum[r1][c2 + 1] -= degree;
                sum[r2 + 1][c1] -= degree;
                sum[r2 + 1][c2 + 1] += degree;
            }
        }        
        
        calc();
        
        // 파괴되지 않은 건물 찾기
        int answer = 0;         
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(sum[i][j] + board[i][j] > 0)
                    answer++;
            }
        }
        
        return answer;
    }
    
    // 누적합 계산 메서드
    private static void calc() {
        // 가로 누적합 구하기
        for(int i = 0 ; i <= N ; i++) {
            for(int j = 0 ; j < M ; j++)
                sum[i][j + 1] += sum[i][j];
        }
        
        // 세로 누적합 구하기
        for(int i = 0 ; i <= M ; i++) {
            for(int j = 0 ; j < N ; j++)
                sum[j + 1][i] += sum[j][i];
        }
    }
}
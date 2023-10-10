import java.util.*;

class Solution {    
    static int val = 1;
    static int row, col;    // 현재 행, 열 위치
    static int dir = 0;     // 방향 (0 : 오른쪽 / 1 : 아래 / 2 : 왼쪽 / 3 : 위쪽)
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        while(val <= n * n) {   // 모두 채워질 때까지 반복
            answer[row][col] = val++;
            
            // 다음 이동할 위치 계산
            if(dir == 0) {  // 오른쪽 방향으로 이동
                if(col == n - 1 || answer[row][col + 1] != 0) {
                    dir = 1;
                    row++;
                }
                else {
                    col++;
                }
            }
            else if(dir == 1) { // 아래쪽 방향으로 이동
                if(row == n - 1 || answer[row + 1][col] != 0) {
                    dir = 2;
                    col--;
                }
                else {
                    row++;
                }
            }
            else if(dir == 2) { // 왼쪽 방향으로 이동
                if(col == 0 || answer[row][col - 1] != 0) {
                    dir = 3;
                    row--;
                }
                else {
                    col--;
                }
            }
            else if(dir == 3) { // 위쪽 방향으로 이동
                if(row == 0 || answer[row - 1][col] != 0) {
                    dir = 0;
                    col++;
                }
                else {
                    row--;
                }
            }
        }
        
        
        return answer;
    }
}
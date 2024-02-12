import java.util.*;

class Solution {
    // 회전 방향 : 시계 방향 ⇒ 끌어올 방향 : 반시계 방향 (남동북서)
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] grid = new int[rows][columns];
        
        int val = 1;
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < columns ; j++)
                grid[i][j] = val++;
        }
        
        int idx = 0;
                
        for(int[] q : queries) {
            int x1 = q[0] - 1;
            int y1 = q[1] - 1;
            int x2 = q[2] - 1;
            int y2 = q[3] - 1;
            
            int x = x1;
            int y = y1;
            int dir = 0;
            
            int firstNum = grid[x][y];
            int min = firstNum;
            
            while(dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx < x1 || nx > x2 || ny < y1 || ny > y2) {
                    dir++;
                }
                else {
                    grid[x][y] = grid[nx][ny];
                    min = Math.min(min, grid[x][y]);
                    x = nx;
                    y = ny;
                }
            }
            
            grid[x][y + 1] = firstNum;
            answer[idx++] = min;
        }
        
        return answer;
    }
}
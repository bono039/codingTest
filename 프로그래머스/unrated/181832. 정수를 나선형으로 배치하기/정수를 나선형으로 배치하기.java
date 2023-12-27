import java.util.*;

class Solution {
    static int n;
    
    static int[] dx = {0,1,0,-1};   // 동남서북
    static int[] dy = {1,0,-1,0};
    
    public int[][] solution(int n) {
        this.n = n;
        int[][] answer = new int[n][n];
        
        answer[0][0] = 1;
        int dir = 0;
        
        int x = 0;
        int y = 0;
        
        for(int i = 2 ; i <= n * n ; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!inRange(nx, ny) || answer[nx][ny] != 0) {
                dir = (dir + 1) % 4;
            }
            
            x += dx[dir];
            y += dy[dir];
            answer[x][y] = i;            
        }        
        
        return answer;
    }
    
    private static boolean inRange(int r, int c) {
        return (0 <= r && r < n && 0 <= c && c < n);
    }
}
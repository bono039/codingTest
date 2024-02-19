import java.util.*;

class Solution {
    static int n;
    
    static int[] dx = {0, 1, 0, -1};   // 동남서북
    static int[] dy = {1, 0, -1, 0};
    
    static boolean[][] visited;
    
    public int[][] solution(int n) {
        this.n = n;
        
        int[][] answer = new int[n][n];
        visited = new boolean[n][n];
        
        int x = 0;
        int y = 0;
        int dir = 0;
        int num = 1;
        answer[x][y] = num;
        visited[x][y] = true;
        
        while(num < n*n) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!inRange(nx, ny) || visited[nx][ny]) {
                dir = (dir + 1) % 4;
            }
            
            nx = x + dx[dir];
            ny = y + dy[dir];
            
            visited[nx][ny] = true;
            answer[nx][ny] = ++num;
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}
import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int r, c;
    
    static char[][] grid;
    static boolean[][] visited;
    
    static int[] start = new int[2];
    static int[] lever = new int[2];
    
    public int solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();
        
        
                
        grid = new char[r][c];        
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                grid[i][j] = maps[i].charAt(j);
                
                if(grid[i][j] == 'S') {
                    start = new int[] {i, j};
                }
                else if(grid[i][j] == 'L') {
                    lever = new int[] {i, j};
                }
            }
        }
        
        visited = new boolean[r][c];
        int result1 = bfs(start, 'L');
        
        visited = new boolean[r][c];
        int result2 = bfs(lever, 'E');       
        
        if(result1 == -1 || result2 == -1) {
            return -1;
        }
        
        return result1 + result2;      
        
    }
    
    private static int bfs(int[] start, char target) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {start[0], start[1], 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            visited[x][y] = true;
            
            if(grid[x][y] == target) {
                return cnt;
            }
            
            for(int d = 0 ; d < 4 ; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, cnt + 1});
                }
            }
        }
        
        return -1;
    }
    
    private static boolean canGo(int x, int y) {
        return (inRange(x, y) && !visited[x][y] && grid[x][y] != 'X');
    }
    
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < r && 0 <= y && y < c);
    }
}
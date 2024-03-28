import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int n, m;
    static char[][] map;
    static boolean[][] visited;    
    static int rx = 0, ry = 0;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        map = new char[n][m];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                map[i][j] = board[i].charAt(j);
                
                if(map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
            }
        }
        
        visited = new boolean[n][m];        
        return bfs();
    }
    
    private static int bfs() {       
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {rx, ry, 0});
        
        int cnt = -1;
        visited[rx][ry] = true; 
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if(map[now[0]][now[1]] == 'G') {
                cnt = now[2];
                break;
            }
            
            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                while(true) {
                    if(inRange(nx, ny) && map[nx][ny] != 'D') {
                        nx += dx[d];
                        ny += dy[d];
                    }
                    else {
                        nx -= dx[d];
                        ny -= dy[d];
                        break;
                    }  
                }
                
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, now[2] +1});
                }
            }
        }
                
        return cnt;
    }
    
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
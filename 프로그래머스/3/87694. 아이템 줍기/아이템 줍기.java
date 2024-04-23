import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int[][] board;
    static int answer;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        board = new int[101][101];
                
        for(int[] r : rectangle) {
            fill(2*r[0], 2*r[1], 2*r[2], 2*r[3]);
        }
                
        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
        return answer;
    }
    
    private static void fill(int x1, int y1, int x2, int y2) {
        for(int i = x1 ; i <= x2 ; i++) {
            for(int j = y1 ; j <= y2 ; j++) {
                if(board[i][j] == 2)    continue;
                
                board[i][j] = 2;
                
                if(i == x1 || i == x2 || j == y1 || j == y2)
                    board[i][j] = 1;
            }
        }
    }
    
    private static void bfs(int sx, int sy, int ex, int ey) {        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sx, sy});
        
        int[][] cost = new int[101][101];
        cost[sx][sy] = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
                        
            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(!inRange(nx, ny))    continue;
                
                if(board[nx][ny] == 1 && cost[nx][ny] == 0) {
                    cost[nx][ny] = cost[now[0]][now[1]] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        
        answer = cost[ex][ey] / 2;
    }
    
    private static boolean inRange(int x, int y) {
        return (0 <= x && x <= 100 && 0 <= y && y <= 100);
    }
}
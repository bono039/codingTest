import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
        
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int x = 0 ; x < 5 ; x++) {
            boolean isOk = true;
            
            for(int i = 0 ; i < 5 ; i++) {
                for(int j = 0 ; j < 5 ; j++) {
                    if(places[x][i].charAt(j) == 'P') {
                        if(!bfs(i, j, places[x]))
                            isOk = false;
                    }
                }
            }
            
            answer[x] = isOk ? 1 : 0;
        }
        
        return answer;
    }
    
    private static boolean bfs(int x, int y, String[] s) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(!inRange(nx, ny) || (nx == x && ny == y))    continue;
                
                int dist = getDist(x, y, nx, ny);
                
                if(s[nx].charAt(ny) == 'P' && dist <= 2)
                    return false;
                else if(s[nx].charAt(ny) == 'O' && dist < 2)
                    q.add(new int[] {nx, ny});
            }
        }
        
        return true;        
    }
    
    private static int getDist(int r1, int c1, int r2, int c2) {
        return (int)Math.abs(r1 - r2) + (int)Math.abs(c1 - c2);
    }
    
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < 5 && 0 <= y && y < 5);
    }
}
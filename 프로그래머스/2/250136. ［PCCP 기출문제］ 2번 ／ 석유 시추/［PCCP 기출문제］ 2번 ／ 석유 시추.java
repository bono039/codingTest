import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int n,m;
    static int[][] map;
    static int[] oil;
    
    static boolean[][] visited;
    static int answer = 0;
    
    public int solution(int[][] land) {        
        n = land.length;
        m = land[0].length;
        
        map = land;
        visited = new boolean[n][m];
        oil = new int[m];        
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(land[j][i] == 1 && !visited[j][i]) {
                    bfs(j, i);
                }
            }
        }
        
        for(int o : oil) {
            answer = Math.max(answer, o);
        }        
        return answer;
    }
    
    private static int bfs(int x, int y) {
        Set<Integer> set = new HashSet<>();
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        
        visited[x][y] = true;
        
        int tmpCnt = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            set.add(now[1]);

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(!inRange(nx, ny) || map[nx][ny] == 0 || visited[nx][ny])    continue;
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
                tmpCnt++;
            }
        }
        
        for(int s : set) {
            oil[s] += tmpCnt;
        }
        
        return tmpCnt;
    }
    
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }
}
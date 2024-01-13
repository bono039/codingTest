import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int r, c;
    static int[][] grid;
    static boolean[][] visited;

    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {        
        r = maps.length;
        c = maps[0].length();
        
        grid = new int[r][c];
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(maps[i].charAt(j) == 'X') {
                    grid[i][j] = -1;
                }
                else {
                    grid[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
                
        visited = new boolean[r][c];
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(!visited[i][j] && grid[i][j] != -1) {
                    bfs(i, j);
                }
            }
        }
        
        // 출력하기
        if(list.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i : list) {
            answer[idx++] = i;
        }
        return answer;
    }
    
    private static void bfs(int x, int y) {
        visited[x][y] = true;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        
        int sum = grid[x][y];
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    sum += grid[nx][ny];
                    q.add(new int[] {nx, ny});
                }
            }
        }
        
        list.add(sum);
    }
    
    private static boolean canGo(int x, int y) {
        return (inRange(x, y) && !visited[x][y] && grid[x][y] != -1);
    }
    
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < r && 0 <= y && y < c);
    }
}
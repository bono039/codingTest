import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int[][] maps, result;
    static boolean[][] visited;
    static int answer = 0;
    
    static int row, col;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        
        row = maps.length;
        col = maps[0].length;
        
        result = new int[row + 1][col + 1];
        visited = new boolean[row + 1][col + 1];
        
        bfs(0, 0);

        return answer;
    }
    
    private static void bfs(int a, int b) {
        visited[a][b] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a, b});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int d = 0 ; d < 4 ; d++) {
                int x = now[0] + dx[d];
                int y = now[1] + dy[d];
                
                if(x < 0 || y < 0 || x >= row || y >= col) continue;
                if(visited[x][y] || maps[x][y] == 0) continue;
                
                if(!visited[x][y] && maps[x][y] == 1) {
                    visited[x][y] = true;
                    result[x][y] = result[now[0]][now[1]] + 1;  // 요기 헷갈림(?)
                    q.add(new int[] {x, y});
                }
            }
        }
        
        answer = (result[row - 1][col - 1] == 0) ? - 1 : (result[row - 1][col - 1] + 1);
    }
}
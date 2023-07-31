import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static int n,m;
    static int[][] map, result;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());   // 세로
        m = Integer.parseInt(st.nextToken());   // 가로
        
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        
        int x = 0, y = 0;
        
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    x = i;
                    y = j;
                }
                else if(map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        
        bfs(x, y);
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(!visited[i][j]) {
                    result[i][j] = -1;
                }
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
    }
    
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)    continue;
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny]=true;
                    result[nx][ny]=result[now[0]][now[1]]+1;
                    queue.add(new int[] {nx,ny});
				}
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        int maxH = 0;
        int minH = 0;
        
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
                minH = Math.min(minH, map[i][j]);
            }
        }
        
        int max = 0;
        for(int k = minH ; k <= maxH ; k++) {
            visited = new boolean[N][N];
            int cnt = 0;
            
            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if(!visited[i][j] && map[i][j] > k) {
                        cnt++;
                        dfs(i, j, k);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
    
    private static void dfs(int a, int b, int height) {
        visited[a][b] = true;
        
        for(int d = 0 ; d < 4 ; d++) {
            int x = a + dx[d];
            int y = b + dy[d];
            
            if(x < 0 || y < 0 || x >= N || y >= N || visited[x][y])  continue;
            
            if(!visited[x][y] && map[x][y] > height) {
                dfs(x, y, height);
            } 
        }
    }
}
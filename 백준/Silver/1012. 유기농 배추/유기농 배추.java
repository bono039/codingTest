import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int[][] map;
    static boolean[][] visited;
    static int T, M, N, K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());

        while(T -- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            map = new int[M][N];
            visited = new boolean[M][N];
            int cnt = 0;
            
            while(K -- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                map[a][b] = 1;
            }
            
            for(int i = 0 ; i< M ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
    
    private static void dfs(int a, int b) {
        if(visited[a][b]) return;
        
        visited[a][b] = true;
        for(int d = 0 ; d < 4 ; d++) {
            int x = dx[d] + a;
            int y = dy[d] + b;
            
            if(x < 0 || x >= M || y < 0 || y >= N)    continue;
            if(!visited[x][y] && map[a][b] == 1) {
                dfs(x, y);
            }
        }
    }
}

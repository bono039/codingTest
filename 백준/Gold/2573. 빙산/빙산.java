import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;

    static int[][] map, melt;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        melt = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    private static void solve() {
        int year = 0;

        while (true) {
            int parts = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        parts++;
                    }
                }
            }

            if (parts == 0) {
                System.out.println(0);
                break;
            }
            else if(parts >= 2) {
                System.out.println(year);
                break;
            }
            
            melt();
            year++;
        }        
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
            
            if(map[nx][ny] == 0)
                melt[x][y]++;
                
            if(!visited[nx][ny] && map[nx][ny] != 0)
                dfs(nx, ny);
        }
    }
    
    static void melt() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                map[i][j] -= melt[i][j]; 
                
                if(map[i][j] < 0)   map[i][j] = 0;
                
                visited[i][j] = false;
                melt[i][j] = 0;
            }
        }
    }
}

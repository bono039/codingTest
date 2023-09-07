import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int N, M, breakCnt;
    static int[][] map, dist;
    static boolean[][][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        dist = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
 
        if(N - 1 == 0 && M - 1 == 0) {
            System.out.println(1);
            System.exit(0);
        }
        
        visited = new boolean[2][N + 1][M + 1];
        System.out.println(bfs(0, 0, 0));
    }
    
    private static int bfs(int breakCnt, int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b, 0});
        
        visited[breakCnt][a][b] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int d = 0 ; d < 4 ; d++) {
                int x = now[0] + dx[d];
                int y = now[1] + dy[d];
                
                if(x < 0 || y < 0 || x >= N || y >= M)    continue;

                if(map[x][y] == 1) {
                    if(now[2] == 0 && !visited[1][x][y]) {
                        visited[now[2]][x][y] = true;
                        dist[x][y] = dist[now[0]][now[1]] + 1;
                        queue.offer(new int[] {x, y, 1});
                    }    
                }
                else {
                    if(!visited[now[2]][x][y]) {
                        visited[now[2]][x][y] = true;
                        dist[x][y] = dist[now[0]][now[1]] + 1;
                        queue.offer(new int[] {x, y, now[2]});
                    }
                }
                
                if(x == N - 1 && y == M - 1) {
                    return dist[x][y] + 1;
                }
            }
            
        } 
        return -1;
    }
}
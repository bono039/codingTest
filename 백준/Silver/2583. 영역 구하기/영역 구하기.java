import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int M, N, K, cnt;
    static int[][] map;
    
    static PriorityQueue<Integer> list = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        
        while(K --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int j = y1 ; j < y2 ; j++) {
                for(int i = x1 ; i < x2 ; i++) {
                    map[j][i] = -1;
                }
            }
        }
        
        for(int i = 0 ; i < M ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(map[i][j] == 0) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        
        sb.append(cnt).append("\n");
        while(!list.isEmpty()) {
            sb.append(list.poll()).append(" ");
        }
        System.out.println(sb);
    }
    
    private static void bfs(int a, int b) {
        if(map[a][b] != 0) return;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a,b});
        map[a][b] = -1;
        int area = 0;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            area++;
            
            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny] == -1) continue;

                queue.add(new int[] {nx, ny});
                map[nx][ny] = -1;
            }
        }
        list.add(area);
    }
}
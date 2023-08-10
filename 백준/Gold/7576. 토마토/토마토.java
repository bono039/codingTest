import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int M, N;
    static int[][] map;
    
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        
        System.out.println(bfs());
    }
    
    private static int bfs() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int d = 0 ; d < 4 ; d++) {
                int x = dx[d] + now[0];
                int y = dy[d] + now[1];
                
                if(x < 0 || y < 0 || x >= N || y >= M) continue;
                if(map[x][y] == 0) {
                    map[x][y] = map[now[0]][now[1]] + 1;
                    queue.add(new int[] {x, y});
                }
            }   
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] == 0)  return -1;
                max = Math.max(max, map[i][j]);
            }
        }
        
        if(max == 1) return 0;
        else         return max - 1;
    }
}
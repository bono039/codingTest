import java.util.*;
import java.io.*;

class tomato {
    int x, y, z;    // 세로, 가로, 면
    
    public tomato(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {0, 0, -1, 1, 0, 0};  // 상하좌우 앞뒤
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    static int M,N,H;
    static int[][][] map;
    
    static Queue<tomato> queue;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());   // 가로
        N = Integer.parseInt(st.nextToken());   // 세로
        H = Integer.parseInt(st.nextToken());   // 높이

        map = new int[H][N][M];
        queue = new LinkedList<>();
            
        for(int k = 0 ; k < H ; k++) {
            for(int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < M ; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    
                    // 익은 토마토라면, 큐에 넣음
                    if(map[k][i][j] == 1)
                        queue.add(new tomato(k, i, j));
                }
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        while(!queue.isEmpty()) {
            tomato t = queue.poll();
            
            for(int d = 0 ; d < 6 ; d++) {
                int x = t.x + dx[d];
                int y = t.y + dy[d];
                int z = t.z + dz[d];
                
                if(x < 0 || y < 0 || z < 0 || x >= N || y >= M || z >= H || map[z][x][y] != 0)  continue;
                queue.add(new tomato(z, x, y));
                map[z][x][y] = map[t.z][t.x][t.y] + 1;
                
            }
        }
        
        int result = Integer.MIN_VALUE;
        
        for(int k = 0 ; k < H ; k++) {
            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < M ; j++) {
                    // 안 익은 토마토가 있는 경우
                    if(map[k][i][j] == 0)   return -1;
                    
                    // 날짜 최댓값 구하기
                    result = Math.max(result, map[k][i][j]);
                }
            }
        }
        
        if(result == 1) return 0;
        else            return result - 1;
    }
}
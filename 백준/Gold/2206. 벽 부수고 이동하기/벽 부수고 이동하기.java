import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
        
        if(N == 1 && M == 1) {
	        System.out.println(1);
	        return;
	    }
	    
	    map = new int[N][M];
	    visited = new boolean[2][N][M];
	    
	    for(int i = 0 ; i < N ; i++) {
	        String str = br.readLine();
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = str.charAt(j) - '0';
	        }
	    }
	    
	    System.out.println(bfs());
	}
	
	private static int bfs() {
	    int breakCnt = 0;
	    
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {0,0,0});
	    
	    visited[breakCnt][0][0] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        int x = now[0];
	        int y = now[1];
	        int crashed = now[2];
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = x + dx[d];
	            int ny = y + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
	            
	            if(map[nx][ny] == 1) {
	                if(crashed == 0 && !visited[1][nx][ny]) {
	                    visited[crashed][nx][ny] = true;
	                    map[nx][ny] = map[x][y] + 1;
	                    q.add(new int[] {nx, ny, 1});
	                }
	            }
	            else {
	                if(!visited[crashed][nx][ny]) {
	                    visited[crashed][nx][ny] = true;
	                    map[nx][ny] = map[x][y] + 1;
	                    q.add(new int[] {nx, ny, crashed});
	                }
	            }
	            
	            if(nx == N -1 && ny == M-1) {
	                return map[nx][ny] + 1;
	            }
	        }
	    }
	    
	    return -1;
	}
}

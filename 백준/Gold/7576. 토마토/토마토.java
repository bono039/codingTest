import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static int[][] map;
    
    static Queue<int[]> q = new ArrayDeque<>();
    static int answer = Integer.MIN_VALUE;
    
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
	                q.add(new int[] {i,j});
	            }
	        }
	    }
	    
	    bfs();
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(map[i][j] == 0) {
	                System.out.println(-1);
	                return;
	            }
	            answer = Math.max(answer, map[i][j]);
	        }
	    }
	    
	    System.out.println(answer == 1 ? 0 : answer - 1);
	}
	
	private static void bfs() {
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
	            
	            if(map[nx][ny] == 0) {
	                map[nx][ny] = map[now[0]][now[1]] + 1;
	                answer = map[nx][ny];
	                q.add(new int[]{nx, ny});
	            }
	        }
	    }
	}
}
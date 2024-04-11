import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M,T;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] pos = new int[2];
    
    static int answer = 10001;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    T = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    visited = new boolean[N][M];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	            
	            if(map[i][j] == 2)
	                pos = new int[]{i, j};
	        }
	    }
	    
	    bfs();
	    System.out.println(answer > T ? "Fail" : answer);
	}
	
	private static void bfs() {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {0, 0});
	    
	    visited[0][0] = true;
	    
	    int size = 0;
	    int cnt = -1;
	    
	    while(!q.isEmpty()) {
	        cnt++;
	        size = q.size();
	        
	        for(int i = 0 ; i < size ; i++) {
	            int[] now = q.poll();
	            
	            if(now[0] == pos[0] && now[1] == pos[1]) {
	                answer = cnt + N-1 - now[0] + M-1 - now[1];
	                continue;
	            }
	            else if(now[0] == N-1 && now[1] == M-1) {
	                answer = Math.min(answer, cnt);
	                return;
	            }
	            
	            for(int d = 0 ; d < 4 ; d++) {
	                int nx = now[0] + dx[d];
    	            int ny = now[1] + dy[d];
    	            
    	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
    	            if(!visited[nx][ny] && map[nx][ny] != 1) {
    	                visited[nx][ny] = true;
    	                q.add(new int[] {nx, ny});
    	            }
	            }
	        }
	    }
	}
}

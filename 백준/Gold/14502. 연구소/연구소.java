import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static int[][] map, tmp;
    static Queue<int[]> q = new ArrayDeque<>();
    
    static int answer = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    dfs(0);
	    System.out.println(answer);
	}
	
	private static void dfs(int cnt) {
	    if(cnt == 3) {
            bfs();
	        return;
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(map[i][j] == 0) {
	                map[i][j] = 1;
	                dfs(cnt + 1);
	                map[i][j] = 0;
	            }	            
	        }
	    }
	}
	
	private static void bfs() {
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(map[i][j] == 2)
	                q.add(new int[]{i, j});
	        }
	    }
	    
	    tmp = new int[N][M];
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++)
	            tmp[i][j] = map[i][j];
	    }
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
	            
	            if(tmp[nx][ny] == 0) {
	                tmp[nx][ny] = 2;
	                q.add(new int[]{nx, ny});
	            }
	        }
	    }
	    
	    getSafeZone();
	}
	
	private static void getSafeZone() {
	    int cnt = 0;
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(tmp[i][j] == 0)
	                cnt++;
	        }
	    }
	    
	    answer = Math.max(answer, cnt);
	}
}

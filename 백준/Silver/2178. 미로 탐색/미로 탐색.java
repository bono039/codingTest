import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    for(int i =  0 ; i < N ; i++) {
	        char[] ch = br.readLine().toCharArray();
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = ch[j] - '0';
	        }
	    }
	    
	    visited = new boolean[N][M];
	    bfs(0,0);
	    System.out.println(map[N-1][M-1]);
	}
	
	private static void bfs(int x, int y) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[]{x, y});
	    
	    visited[x][y] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
	            if(visited[nx][ny]) continue;
	            
	            if(map[nx][ny] == 1) {
	                visited[nx][ny] = true;
	                map[nx][ny] = map[now[0]][now[1]] + 1;
	                q.add(new int[]{nx, ny});
	            }
	        }
	    }
	}
}
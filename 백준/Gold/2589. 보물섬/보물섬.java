import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new char[N][M];
	    for(int i = 0 ; i < N ; i++) {
	        String str = br.readLine();
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = str.charAt(j);
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(map[i][j] == 'L') {
	                visited = new boolean[N][M];
	                answer = Math.max(answer, bfs(i, j));
	            }
	        }
	    }
	    
	    System.out.println(answer);
	}
	
	private static int bfs(int x, int y) {
	    visited[x][y] = true;
	    
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y, 0});
	    
	    int dist = 0;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
	            
	            if(!visited[nx][ny] && map[nx][ny] == 'L') {
	                visited[nx][ny] = true;
	                q.add(new int[]{nx, ny, now[2] + 1});
	                dist = Math.max(dist, now[2] + 1);
	            }
	        }
	    }
	    
	    return dist;
	}
}

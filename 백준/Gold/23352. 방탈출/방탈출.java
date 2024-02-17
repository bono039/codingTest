import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static int[][] grid;
    
    static int route = 0;
    static int max = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    grid = new int[N][M];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            grid[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(grid[i][j] != 0)
	                bfs(i, j);
	        }
	    }
	    
	    System.out.println(max);
	}
	
	private static void bfs(int x, int y) {   
	    boolean[][] visited = new boolean[N][M];
	    visited[x][y] = true;
	    
        Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y, 0});
        
	    int start = grid[x][y];
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        int a = now[0];
	        int b = now[1];
	        int move = now[2];
	        int end = grid[a][b];
	        
	        if(move >= route) {
	            if(move > route)
	                max = start + end;
	            else 
	                max = Math.max(max, start + end);
	                
	            route = move;
	        }
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = a + dx[d];
	            int ny = b + dy[d];
	            
	            if(!inRange(nx, ny) || grid[nx][ny] == 0 || visited[nx][ny])    continue;
	            
	            visited[nx][ny] = true;
	            q.add(new int[] {nx, ny, move + 1});
	        }
	    }
	}
	
	private static boolean inRange(int x, int y) {
	    return (0 <= x && x < N && 0 <= y && y < M);
	}
}

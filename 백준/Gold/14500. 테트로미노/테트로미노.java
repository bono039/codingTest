import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    
    static int max = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    grid = new int[N][M];
	    visited = new boolean[N][M];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            grid[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            visited[i][j] = true;
	            dfs(i, j, 1, grid[i][j]);
	            visited[i][j] = false;
	            
	            shape1(i, j);
	            shape2(i, j);
	            shape3(i, j);
	            shape4(i, j);
	        }
	    }
	    
	    System.out.println(max);
	}
	
	private static void dfs(int x, int y, int depth, int sum) {
	    if(depth == 4) {
	        max = Math.max(max, sum);
	        return;
	    }
	    
	    for(int d = 0 ; d < 4 ; d++) {
	        int nx = x + dx[d];
	        int ny = y + dy[d];
	        
	        if(inRange(nx,ny) && !visited[nx][ny]) {
	            visited[nx][ny] = true;
	            dfs(nx, ny, depth +1, sum + grid[nx][ny]);
	            visited[nx][ny] = false;
	        }
	    }
	}
	
	private static void shape1(int x, int y) {
	    if(x + 1 >= N || y + 2 >= M)  return;
	    
	    int tmp = grid[x][y] + grid[x][y+1] + grid[x][y+2] + grid[x+1][y+1];
	    max = Math.max(max, tmp);
	    return;
	}
	
	private static void shape2(int x, int y) {
	    if(x + 2 >= N || y + 1 >= M)  return;
	    
	    int tmp = grid[x][y + 1] + grid[x+1][y] + grid[x+1][y+1] + grid[x+2][y+1];
	    max = Math.max(max, tmp);
	    return;
	}	
	
	private static void shape3(int x, int y) {
	    if(x + 2 >= N || y + 1 >= M)  return;
	    
	    int tmp = grid[x][y] + grid[x+1][y] + grid[x+2][y] + grid[x+1][y+1];
	    max = Math.max(max, tmp);
	    return;
	}
	
	private static void shape4(int x, int y) {
	    if(x + 1 >= N || y + 2 >= M)  return;
	    
	    int tmp = grid[x][y+1] + grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2];
	    max = Math.max(max, tmp);
	    return;
	}
	
	private static boolean inRange(int x, int y) {
	    return (0 <= x && x < N && 0 <= y && y < M);
	}
}

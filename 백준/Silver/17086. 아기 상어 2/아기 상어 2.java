import java.util.*;
import java.io.*;

public class Main {    
    static int[] dx = {-1,1,0,0, -1,-1,1,1};
    static int[] dy = {0,0,-1,1, -1,1,-1,1};
    
    static int N,M;
    static int[][] board;
    static boolean[][] visited;    
    static int max = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    board = new int[N][M];	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            board[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(board[i][j] == 1)  continue;
	            
	            max = Math.max(max, bfs(i, j));
	        }
	    }
	    
	    System.out.println(max);
	}
	
	private static int bfs(int x, int y) {      
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y, 0});
        
        visited = new boolean[N][M];
        visited[x][y] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 8 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
	            if(visited[nx][ny]) continue;
	            
	            if(board[nx][ny] == 1) {
	                return now[2] + 1;
	            }
	            
	            visited[nx][ny] = true;
	            q.add(new int[] {nx, ny, now[2] + 1});
	        }
	    }
	    
	    return 0;
	}
}

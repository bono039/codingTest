import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    
	    for(int i = 0 ; i < N ; i++) {
	        String s = br.readLine();
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = s.charAt(j) - '0';
	        }
	    }
	    
	    visited = new boolean[N][M];
	    bfs(0, 0);
	    
	    System.out.println(map[N - 1][M - 1]);
	}
	
	private static void bfs(int x, int y) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y});
	    
	    visited[x][y] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        int nowX = now[0];
	        int nowY = now[1];
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = nowX + dx[d];
	            int ny = nowY + dy[d];
	            
	            if(!inRange(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) continue;

	            visited[nx][ny] = true;
	            map[nx][ny] = map[nowX][nowY] + 1;
	            q.add(new int[] {nx, ny});
	        }
	    }
	}
	
	private static boolean inRange(int x, int y) {
	    return (0 <= x && x < N && 0 <= y && y < M);
	}
}

import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N, M;
    static int H,W,sr,sc,fr,fc;
    static int[][] grid;
    static boolean[][] visited;
    
    static List<int[]> wallList = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    grid = new int[N + 1][M + 1];
	    visited = new boolean[N + 1][M + 1];
	    	    
	    for(int i = 1 ; i <= N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 1 ; j <= M ; j++) {
	            grid[i][j] = Integer.parseInt(st.nextToken());
	            
	            if(grid[i][j] == 1)
	                wallList.add(new int[] {i, j});
	        }
	    }
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    H = Integer.parseInt(st.nextToken());
	    W = Integer.parseInt(st.nextToken());
	    sr = Integer.parseInt(st.nextToken());
	    sc = Integer.parseInt(st.nextToken());
	    fr = Integer.parseInt(st.nextToken());
	    fc = Integer.parseInt(st.nextToken());
	    
	    System.out.println(bfs());
	}
	
	private static int bfs() {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {sr, sc, 0});
	    visited[sr][sc] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        if(now[0] == fr && now[1] == fc) {
	            return now[2];
            }
	        
    	    for(int d = 0 ; d < 4 ; d++) {
    	        int nx = now[0] + dx[d];
    	        int ny = now[1] + dy[d];
    	        
    	        if(!inRange(nx, ny) || visited[nx][ny] || grid[nx][ny] == 1)    continue;
    	        if(!isPossible(nx, ny)) continue;
    	        
    	        q.add(new int[] {nx, ny, now[2] + 1});
    	        visited[nx][ny] = true;
    	    }	        
	    }
	    
	    return -1;
	}
	
	private static boolean inRange(int r, int c) {
	    return (1 <= r && r <= N && 1 <= c && c <= M);
	}
	
	private static boolean isPossible(int r, int c) {
	    if(r + H - 1 > N || c + W - 1 > M)  return false;
	    
	    for(int i = 0 ; i < wallList.size() ; i++) {
	        int[] wall = wallList.get(i);
	        
	        if(r <= wall[0] && wall[0] < r + H && c <= wall[1] && wall[1] < c + W)
	            return false;
	    }
	    return true;
	}
}

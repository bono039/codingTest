import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N, M;
    static int[][] map;
    
    static int time = 0;
    static List<Integer> list = new ArrayList<>();
    
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
	    
	    while(true) {
	        if(!cheeseExists()) break;
	            
	        time++;
	        melt();
	    }
	    
	    System.out.println(time);
	    System.out.println(list.get(list.size() - 1));
	}
	
	private static boolean cheeseExists() {
	    boolean exists = false;
	    int cnt = 0;
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(map[i][j] == 1) {
	                exists = true;
	                cnt++;
	            }
	        }
	    }
	    
	    if(cnt != 0)    list.add(cnt);
	    
	    return exists;
	}
	
	private static void melt() {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {0, 0});
	    
	    boolean[][] visited = new boolean[N][M];
	    visited[0][0] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(!inRange(nx, ny) || visited[nx][ny])    continue;
	            
	            if(map[nx][ny] == 0) {
	                visited[nx][ny] = true;
	                q.add(new int[] {nx, ny});
	            }
	            else if(map[nx][ny] == 1) {
	                visited[nx][ny ] = true;
	                map[nx][ny] = 0;
	            }
	        }
	    }
	}
	
	private static boolean inRange(int x, int y) {
	    return 0 <= x && x < N && 0 <= y && y < M;
	}
}

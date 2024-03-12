import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static int[][] map, air;
    static int cheeseCnt, time = 0;
    
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
	            
	            if(map[i][j] == 1)
	                cheeseCnt++;
	        }
	    }
	    
	    while(cheeseCnt != 0)
	        melt();
	    
	    System.out.println(time);
	}
	
	private static void melt() {
	    air = new int[N][M];
	    
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[]{0, 0});
	    air[0][0] = -1;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(!inRange(nx, ny))    continue;
	            
	            if(map[nx][ny] == 1)
	                air[nx][ny]++;
	            
	            if(map[nx][ny] == 0 && air[nx][ny] == 0) {
	                air[nx][ny] = -1;
	                q.add(new int[] {nx, ny});
	            }
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(air[i][j] >= 2) {
	                cheeseCnt--;
	                map[i][j] = 0;
	            }
	        }
	    }
	    
	    time++;
	}
	
	private static boolean inRange(int x, int y) {
	    return 0 <= x && x < N && 0 <= y && y < M;
	}
}

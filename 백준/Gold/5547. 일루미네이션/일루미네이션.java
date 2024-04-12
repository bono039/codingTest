import java.util.*;
import java.io.*;

public class Main {
    static int[][] odd = {{0,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}};   // 홀수 행
    static int[][] even = {{0,-1}, {-1,-1}, {-1,0}, {0,1}, {1,0}, {1,-1}};
    
    static int W,H;
    static int[][] map, result;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    W = Integer.parseInt(st.nextToken());   // 열
	    H = Integer.parseInt(st.nextToken());   // 행
	    
	    map = new int[H+2][W+2];
	    result = new int[H+2][W+2];
	    visited = new boolean[H+2][W+2];
	    
	    
	    for(int i = 1 ; i <= H ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 1 ; j <= W ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	            
	            if(map[i][j] == 1)
	                visited[i][j] = true;
	        }
	    }
	    
	    bfs();
	    
	    int answer = 0;
	    for(int i = 0 ; i < H+2 ; i++) {
	        for(int j = 0 ; j < W+2 ; j++) {
	            answer += result[i][j];
	        }
	    }
	    
	    System.out.println(answer);
	}
	
	private static void bfs() {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {0, 0});
	    visited[0][0] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 6; d++) {
	            int nx = 0;
	            int ny = 0;
	            
	            if(now[0] % 2 == 1) {
	                nx = now[0] + odd[d][0];
	                ny = now[1] + odd[d][1];
	            }
	            else {
	                nx = now[0] + even[d][0];
	                ny = now[1] + even[d][1];
	            }
	            
	            if(nx < 0 || nx >= H+2 || ny < 0 || ny >= W+2)  continue;
	            
	            if(map[nx][ny] == 1) {
	                result[now[0]][now[1]]++;
	                continue;
	            }
	            
	            if(!visited[nx][ny]) {
	                visited[nx][ny] = true;
	                q.add(new int[]{nx, ny});
	            }
	        }
	    }
	}
}

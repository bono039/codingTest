import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    // 말인 경우 대각선 4방향 이동
    static int[] hx = {1,2,2,1,-1,-2,-2,-1};
    static int[] hy = {2,1,-1,-2,-2,-1,1,2};
    
    static int K,W,H;
    static int[][] map;
    static boolean[][][] chk;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		for(int i = 0 ; i < H ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 0 ; j < W ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		chk = new boolean[H][W][K+1];
		System.out.println(bfs());
	}
	
	private static int bfs() {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[]{0,0,0,0});
	    
	    chk[0][0][0] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        int px = now[0];
	        int py = now[1];
	        int chance = now[2];
	        int cnt = now[3];
	        
	        if(px == W-1 && py == H-1) {
	            return cnt;
	        }
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = px + dx[d];
	            int ny = py + dy[d];
	            
	            if(nx < 0 || nx > W-1 || ny < 0 || ny > H-1)    continue;
	            if(chk[ny][nx][chance]) continue;
	            
	            if(map[ny][nx] != 1) {
	                chk[ny][nx][chance] = true;
	                q.add(new int[] {nx, ny, chance, cnt + 1});
	            }
	        }
	        
	        if(chance < K) {
	            for(int d = 0 ; d < 8 ; d++) {
	                int nx = px + hx[d];
	                int ny = py + hy[d];
	                
	                if(nx < 0 || nx > W-1 || ny < 0 || ny > H-1)    continue;
	                if(chk[ny][nx][chance + 1]) continue;
	                
	                if(map[ny][nx] != 1) {
	                    chk[ny][nx][chance + 1] = true;
	                    q.add(new int[] {nx, ny, chance + 1, cnt + 1});
	                }
	            }
	        }
	    }
	    
	    return -1;
	}
}
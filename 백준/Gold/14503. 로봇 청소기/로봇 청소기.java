import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int N, M;
    static int r, c;
    static int dir;
    static int cnt = 1;
    
    static int[][] map;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    String[] str = br.readLine().split(" ");
	    r = Integer.parseInt(str[0]);
	    c = Integer.parseInt(str[1]);
	    dir = Integer.parseInt(str[2]);
	    
	    map = new int[N][M];
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }

	    dfs(r, c);
	    
		System.out.println(cnt);
	}
	
	private static void dfs(int x, int y) {
	    map[x][y] = -1;

        for(int i = 0 ; i < 4 ; i++) {
            dir = (dir + 3) % 4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(inRange(nx, ny) && map[nx][ny] == 0) {
                cnt++;
                dfs(nx, ny);
                
                return;                
            }
        }

        int back = (dir + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        
        if(inRange(bx, by) && map[bx][by] != 1) {
            dfs(bx, by);
        }
	}
	
	private static boolean inRange(int x, int y) {
	    return (0 <= x && x < N && 0 <= y && y < M);
	}
}

import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int n,m;
    static int[][] grid;
    static boolean[][] visited;
    
    static List<Integer> list = new ArrayList<>();
    
    static int time, leftCnt;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    // 0 : 빈 칸 / 1 : 치즈
	    // 치즈에 1개 이상의 구멍
	    // 공기와 접촉된 칸은 1시간 후 녹음
	    
	    // 테두리 치즈만 녹인다.
	    grid = new int[n][m];
	    visited = new boolean[n][m];
	    
	    int tmp = 0;
	    
	    for(int i = 0 ; i < n ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < m ; j++) {
	            grid[i][j] = Integer.parseInt(st.nextToken());
	            if(grid[i][j] == 1) tmp++;
	        }
	    }
        list.add(tmp);
	    
	    while(true) {
	        if(cntCheese() == 0) break;
	        
	        init();
	        bfs(0, 0);
	        melt();
	        time++;
	    }
	    
	    System.out.println(time);
	    System.out.println(list.get(list.size() - 2));
	}
	
	private static int cntCheese() {
	    int cnt = 0;
	    for(int i = 0 ; i < n ; i++) {
	        for(int j = 0 ; j < m ; j++) {
	            if(grid[i][j] == 1) {
	                cnt++;
	            }
	        }
	    }
	    
	    return cnt;
	}
	
	private static void init() {
	    for(int i = 0 ; i < n ; i++)
	        for(int j = 0 ; j < m ; j++)
	            visited[i][j] = false;
	}

	private static void bfs(int x, int y) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y});
	    
	    visited[x][y] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int dir = 0 ; dir < 4 ; dir++) {
	            int nx = now[0] + dx[dir];
	            int ny = now[1] + dy[dir];
	            
	            if(canGo(nx, ny)) {
	                q.add(new int[]{nx, ny});
	                visited[nx][ny] = true;
	            }
	        }
	    }
	}
	
	private static void melt() {
	    for(int i = 0 ; i < n ; i++) {
	        for(int j = 0 ; j < m ; j++) {
	            if(grid[i][j] == 1 && airAround(i, j)) {
	                grid[i][j] = 0;
	            }
	        }
	    }
	    
	    list.add(cntCheese());
	}
	
	private static boolean airAround(int x, int y) {
	    for(int dir = 0 ; dir < 4 ; dir++) {
	        int nx = x + dx[dir];
	        int ny = y + dy[dir];
	        
	        if(inRange(nx, ny) && grid[nx][ny] == 0 && visited[nx][ny]) {
	            return true;
	        }
	    }
	    
	    return false;
	}
	
	private static boolean canGo(int x, int y) {
	    return (inRange(x, y) && !visited[x][y] && grid[x][y] == 0);
	}
	
	private static boolean inRange(int x, int y) {
	    return (0 <= x && x < n && 0 <= y && y < m);
	}
}

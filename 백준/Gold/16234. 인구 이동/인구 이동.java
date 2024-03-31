import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int N,L,R;
    static int[][] map;
    static boolean[][] connected, visited;
    static int cnt = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    L = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][N];
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < N ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken()); 
	        }
	    }
	    
	    connected = new boolean[N][N];
	    visited = new boolean[N][N];
	    
	    while(move()) {
            cnt++;
            visited = new boolean[N][N];
	    }
	    
	    System.out.println(cnt);
	}
	
	private static void bfs(int x, int y) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y});
	    
	    List<int[]> list = new ArrayList<>();
	    list.add(new int[] {x, y, map[x][y]});
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dr[d];
	            int ny = now[1] + dc[d];
	            
	            if(inRange(nx, ny) && !visited[nx][ny] && betweenLR(now[0], now[1], nx, ny)) {
	                list.add(new int[] {nx, ny, map[nx][ny]});
	                visited[nx][ny] = true;
	                q.add(new int[]{nx, ny});
	            }
	        }
	    }
	    
	    if(list.size() == 1) return;
	    
	    int total = 0;
	    for(int[] arr : list) {
	        total += arr[2];
	    }
	    total /= list.size();
	    
	    for(int[] arr : list) {
	        map[arr[0]][arr[1]] = total;
	    }
	}
	
	private static boolean move() {
	    boolean ok = false;
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(!visited[i][j]) {
	                boolean opened = false;
	                
	                for(int d = 0 ; d < 4 ; d++) {
	                    int nx = i + dr[d];
	                    int ny = j + dc[d];
	                    
	                    if(inRange(nx,ny) && betweenLR(i, j, nx, ny)) {
	                        opened = true;
	                        ok = true;
	                    }
	                }
	                
	                visited[i][j] = true;
	                if(opened) {
	                    bfs(i, j);
	                }
	            }
	        }
	    }
	    
	    return ok;
	}
	
	private static boolean betweenLR(int a, int b, int c, int d) {
	    int tmp = Math.abs(map[a][b] - map[c][d]);
	    return L <= tmp && tmp <= R;
	}
	
	private static boolean inRange(int r, int c) {
	    return 0 <= r && r < N && 0 <= c && c < N;
	}
}

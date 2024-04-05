import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static int[][] map, tmp;
    static boolean[][] visited;
    
    static int answer = 0;
    
    static List<int[]> emptyList = new ArrayList<>();
    static List<int[]> wallsList = new ArrayList<>();
    static List<int[]> virusList = new ArrayList<>();
    static boolean[] dfsVisited;
    
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
	            
	            if(map[i][j] == 0) {
	                emptyList.add(new int[]{i, j});
	            }
	            else if(map[i][j] == 2) {
	                virusList.add(new int[]{i, j});
	            }
	        }
	    }
	    
	    dfsVisited = new boolean[emptyList.size()];
	    dfs(0, 0);
	    System.out.println(answer);
	}
	
	private static void dfs(int idx, int cnt) {
	    if(cnt == 3) {
	        setWalls();
	        virus();
	        getSafeZone();
	        init();
	        return;
	    }
	    
	    for(int i = idx ; i < emptyList.size() ; i++) {
	        if(!dfsVisited[i]) {
	            dfsVisited[i] = true;
	            dfs(i + 1, cnt + 1);
	            dfsVisited[i] = false;
	        }
	    }
	}
	
	private static void setWalls() {
	    tmp = new int[N][M];
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++)
	            tmp[i][j] = map[i][j];
	    }
	    
	    for(int i = 0 ; i < dfsVisited.length ; i++) {
	        if(dfsVisited[i]) {
	            int x = emptyList.get(i)[0];
	            int y = emptyList.get(i)[1];
	            tmp[x][y] = 1;
	        }
	    }
	}
	
	private static void virus() {
	    visited = new boolean[N][M];
	    
	    for(int[] now : virusList) {
	        int i = now[0];
	        int j = now[1];
	        
            if(!visited[i][j]) {
                visited[i][j] = true;
                bfs(i, j);
            }
	    }
	}
	
	private static void bfs(int x, int y) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y});
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
	            
	            if(!visited[nx][ny] && tmp[nx][ny] == 0) {
	                visited[nx][ny] = true;
	                tmp[nx][ny] = 2;
	                q.add(new int[]{nx, ny});
	            }
	        }
	    }
	}
	
	private static void getSafeZone() {
	    int cnt = 0;
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(tmp[i][j] == 0)
	                cnt++;
	        }
	    }
	    
	    answer = Math.max(answer, cnt);
	}
	
	private static void init() {
	    wallsList.clear();
	    visited = new boolean[N][M];
	}
}
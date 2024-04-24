import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    
    static List<int[]> virusList = new ArrayList<>();
    static List<Integer> tmpList = new ArrayList<>();
    static boolean[] chk;
    
    static int answer = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        String[] str = br.readLine().split(" ");
	        for(int j = 0 ; j < N ; j++) {
	            map[i][j] = str[j].charAt(0) - '0';
	            
	            if(map[i][j] == 2) {
	                virusList.add(new int[]{i, j});
	            }
	        }
	    }
	    
	    chk = new boolean[virusList.size()];
	    dfs(0, 0);
	    
	    System.out.println(answer == INF ? -1 : answer);
	}
	
	private static void dfs(int idx, int cnt) {
	    if(cnt == M) {
	        bfs();
	        return;
	    }
	    
	    for(int i = idx ; i < virusList.size() ; i++) {
	        if(!chk[i]) {
	            chk[i] = true;
	            tmpList.add(i);
	            dfs(i + 1, cnt + 1);
	            chk[i] = false;
	            tmpList.remove(tmpList.size() - 1);
	        }
	    }
	}
	
	private static void bfs() {
	    Queue<int[]> q = new ArrayDeque<>();
	    visited = new boolean[N][N];
	    
	    int result = 0;
	    
        for(int i : tmpList) {
            int x = virusList.get(i)[0];
            int y = virusList.get(i)[1];
            visited[x][y] = true;
            q.add(new int[]{x, y});
        }
	    
	    while(!q.isEmpty()) {
	        int size = q.size();
	        
	        for(int i = 0 ; i < size ; i++) {
	            int[] now = q.poll();
	            
    	        for(int d = 0 ; d < 4 ; d++) {
    	            int nx = now[0] + dx[d];
    	            int ny = now[1] + dy[d];
    	            
    	            if(!inRange(nx,ny) || visited[nx][ny])  continue;
    	            
	                if(map[nx][ny] != 1) {
	                    visited[nx][ny] = true;
    	                q.add(new int[] {nx, ny});
	                }
    	        }
	        }
	        result++;
	    }
	    
	    if(chk()) {
	        answer = Math.min(answer, result - 1);
	    }
	}
	
	private static boolean chk() {
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(map[i][j] != 1 && !visited[i][j])
	                return false;
	        }
	    }
	    return true;
	}
	
	private static boolean inRange(int x, int y) {
	    return 0 <= x && x < N && 0 <= y && y < N;
	}
}

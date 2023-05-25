import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    static int N, M, K;
    static int max;
    static int cnt;
    
    static int[][]     map;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < K ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    
		    map[x - 1][y - 1] = 1;
		}
		
		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < M ; j++) {
		        if(!visited[i][j] && map[i][j] != 0) {
		            cnt = 0;
		            BFS(i, j);
		            max = Math.max(max, cnt);
		        }
		    }
		}
		System.out.println(max);
	}
	
	static void BFS(int x, int y) {
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[] {x, y});
	    
	    visited[x][y] = true;
	    cnt++;
	    
	    while(!queue.isEmpty()) {
	        int[] now = queue.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int curX = now[0] + dx[d];
	            int curY = now[1] + dy[d];
	            
	            if(curX < 0 || curX >= N || curY < 0 || curY >= M ) continue;
	            if(!visited[curX][curY] && map[curX][curY] != 0) {
	                queue.add(new int[] {curX, curY});
	                visited[curX][curY] = true;
	                cnt++;
	            }
	        }
	    }
	}
}
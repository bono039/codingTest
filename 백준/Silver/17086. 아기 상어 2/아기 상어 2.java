import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {0,  0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {1, -1,  0, 0, -1,  1,-1, 1};
    
    static int N, M, answer;
    static int[][] map;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1];
		
		// 입력 받기
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    for(int j = 0 ; j < M ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		// 각 점마다 BFS 수행
		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < M ; j++) {
		        if(map[i][j] == 1) continue;
		        
    		    answer = Math.max(answer, bfs(i, j));
		    }
		}		
		
		System.out.println(answer);
	}
	
	static int bfs(int x, int y) {
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[] {x, y, 0});
	    
	    visited = new boolean[N + 1][M + 1];
	    visited[x][y] = true;
	    
	    while(!queue.isEmpty()) {
	        int[] now = queue.poll();
	        
	        for(int d = 0 ; d < 8 ; d++) {
    	        int newX = now[0] + dx[d];
    	        int newY = now[1] + dy[d];
    	        int newDistance = now[2] + 1;
	            
	            if(newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
	            if(visited[newX][newY]) continue;
	            
	            if(map[newX][newY] == 1) {
	                return newDistance;
	            }
	            
	            queue.offer(new int[] {newX, newY, newDistance});
	            visited[newX][newY] = true;
	        }
	    }
	    return 0;
	}
}
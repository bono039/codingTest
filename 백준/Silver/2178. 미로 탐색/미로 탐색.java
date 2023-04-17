import java.util.*;
import java.io.*;

public class Main {
    // 상하좌우 탐색 위한 배열 선언
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static boolean[][] visited;
    static int[][] A;
    
    static int N, M;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());   // row
		M = Integer.parseInt(st.nextToken());   // col
		
		A = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    
		    String line = st.nextToken();
		    
		    for(int j = 0 ; j < M ; j++) {
		        A[i][j] = Integer.parseInt(line.substring(j, j + 1));
		    }
		}
		
		BFS(0, 0);
		System.out.println(A[N - 1][M - 1]);
	}
	
	// BFS 구현
	public static void BFS(int i, int j) {
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[] {i, j});
	    visited[i][j] = true;
	    
	    while(!queue.isEmpty()) {
	        int now[] = queue.poll();
	        
	        for(int k = 0 ; k < 4 ; k++) {
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            // 좌표 유효성 검사
	            if(x >= 0 && y >= 0 && x < N && y < M) {
	                if(A[x][y] != 0 && !visited[x][y]) {
	                    visited[x][y] = true;
	                    A[x][y] = A[now[0]][now[1]] + 1;    // 깊이 업데이트
	                    queue.add(new int[] {x,y});
	                }
	            }
	        } 
	    }
	}
}
import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};    // 좌우
    static int[] dy = {1, -1, 0, 0};    // 상하
    
    static boolean[][] visited;
    static int[][] A;
    
    static int N, M;    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		
		A = new int[N][M];  // 101?
		
		// 입력 받기
		for(int i = 0 ; i < N ; i++) {
		    String str = br.readLine();
		    for(int j = 0 ; j < M ; j++) {
		        A[i][j] = str.charAt(j) - '0';
		    }
		}
		
        BFS(0, 0);
		System.out.println(A[N - 1][M - 1]);
	}
	
	static void BFS(int x, int y) {
	    visited[x][y] = true;
	    
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[] {x, y});
	    
	    while(!queue.isEmpty()) {
	        int[] now = queue.poll();
	        
	        // 상하좌우 이동
	        for(int d = 0 ; d < 4 ; d++) {
	            int newX = now[0] + dx[d];
	            int newY = now[1] + dy[d];
	            
	            if(0 <= newX && newX < N && 0 <= newY && newY < M && !visited[newX][newY] && A[newX][newY]!= 0) {
	                visited[newX][newY] = true;
	                A[newX][newY] = A[now[0]][now[1]] + 1;  //  깊이 업데이트
	                queue.add(new int[]{newX, newY});
	            }       
	        }
	    }
	}
}
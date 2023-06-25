import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    static int n, m;    // 세로, 가로
    
    static int[][] paper;   // 인접 행렬
    static boolean[][] visited; // 방문 배열
    static int paintingGroup = 0;   // 그림 개수 (= 그림 그룹 수. 그룹 나누기)
    static int maxWidth;        // 가장 넓은 그림의 넓이 (Math.max로 비교해서)
    static int result;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());   // 세로
		m = Integer.parseInt(st.nextToken());   // 가로
		
		// 변수들 초기화
		paper = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		
		// 입력 받기
		for(int i = 1 ; i <= n ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    
		    for(int j = 1 ; j <= m ; j++) {
		        paper[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		// 각 점에 대해 bfs 수행?
		for(int i = 1 ; i <= n ; i++) {
		    for(int j = 1 ; j <= m ; j++) {
		        if(!visited[i][j] && paper[i][j] == 1) {
    		        paintingGroup++;
    		        bfs(i, j);
    		        maxWidth = Math.max(maxWidth, result);
		        }
		    }
		}
		
		System.out.println(paintingGroup + "\n" + maxWidth);
	}
	
	private static void bfs(int a, int b) {
	    visited[a][b] = true;
	    result = 1;
	    
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[] {a, b});
	    
	    while(!queue.isEmpty()) {
	        int[] now = queue.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int x = now[0] + dx[d];
	            int y = now[1] + dy[d];
	            
	            if(1 <= x && x <= n && 1 <= y && y <= m && !visited[x][y] && paper[x][y] == 1) {
	                visited[x][y] = true;
	                queue.add(new int[] {x, y});
	                result++;
	            }
	        }
	    }
	}
}

import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    static int n, m;
    
    static int[][] paper;
    static boolean[][] visited;
    static int paintingGroup = 0;
    static int maxWidth;
    static int tmpWidth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		paper = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		for(int i = 1 ; i <= n ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 1 ; j <= m ; j++) {
		        paper[i][j] = Integer.parseInt(st.nextToken());
		    }
		}

		for(int i = 1 ; i <= n ; i++) {
		    for(int j = 1 ; j <= m ; j++) {
		        if(!visited[i][j] && paper[i][j] == 1) {
    		        paintingGroup++;
    		        bfs(i, j);
    		        maxWidth = Math.max(maxWidth, tmpWidth);
		        }
		    }
		}

		System.out.println(paintingGroup + "\n" + maxWidth);
	}

	private static void bfs(int a, int b) {
	    visited[a][b] = true;
	    tmpWidth = 1;

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
	                tmpWidth++;
	            }
	        }
	    }
	}
}

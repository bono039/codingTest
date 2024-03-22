import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    
    static int N,M;
    static int[][] A;
    static boolean[][] visited;
    static Queue<int[]> clouds = new ArrayDeque<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    A = new int[N][N];
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < N ; j++) {
	            A[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    clouds.add(new int[] {N-1, 0});
	    clouds.add(new int[] {N-1, 1});
	    clouds.add(new int[] {N-2, 0});
	    clouds.add(new int[] {N-2, 1});
        
        visited = new boolean[N][N];
        visited[N-1][0] = true;
        visited[N-1][1] = true;
        visited[N-2][0] = true;
        visited[N-2][1] = true;

	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int d = Integer.parseInt(st.nextToken());
	        int s = Integer.parseInt(st.nextToken());
	        
	        visited = new boolean[N][N];
	        step12(d-1, s);
	        step34();
	        step5();
	    }
	    
	    System.out.println(printSum());
	}
	
	private static void step12(int d, int s) {
	    for(int[] c : clouds) {
	        c[0] = (c[0] + (dx[d] + N) * s) % N;
	        c[1] = (c[1] + (dy[d] + N) * s) % N;
	        A[c[0]][c[1]]++;
	        visited[c[0]][c[1]] = true;
	    }
	}
	
	private static void step34() {
	    while(!clouds.isEmpty()) {
	        int[] now = clouds.poll();
	        addWater(now[0], now[1]);
	    }
	}

	private static void addWater(int x, int y) {
	    for(int i = 1 ; i <= 7 ; i += 2) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        
	        if(inRange(nx, ny) && A[nx][ny] > 0)
	            A[x][y]++;
	    }
	}
	
	private static void step5() {
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(A[i][j] >= 2 && !visited[i][j]) {
	                clouds.add(new int[] {i, j});
	                A[i][j] -= 2;
	            }
	        }
	    }
	}
	
	private static int printSum() {
	    int sum = 0;
	    
	    for(int[] i : A) {
	        for(int j : i)
	            sum += j;
	    }
	    
        return sum;
	}
	
	
	private static boolean inRange(int x, int y) {
	    return 0 <= x && x < N && 0 <= y && y < N;
	}
}

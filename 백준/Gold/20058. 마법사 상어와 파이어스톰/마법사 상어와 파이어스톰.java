import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int N,Q;
    static int[][] A;
    static boolean[][] visited;
    static int len;
    static int max = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    Q = Integer.parseInt(st.nextToken());
	    
	    len = (int)Math.pow(2,N);
	    
	    A = new int[len][len];
	    for(int i = 0 ; i < len ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < len ; j++) {
	            A[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    while(Q --> 0) {
	        int L = Integer.parseInt(st.nextToken());
	        A = divide(L);
	        A = melt();
	    }
	    
	    int sum = 0;
	    for(int i = 0 ; i < len ; i++) {
	        for(int j = 0 ; j < len ; j++) {
	            sum += A[i][j];
	        }
	    }
	    System.out.println(sum);
	    
	    visited = new boolean[len][len];
	    for(int i = 0 ; i < len ; i++) {
	        for(int j = 0 ; j < len ; j++) {
	            if(!visited[i][j] && A[i][j] != 0) {
	                max = Math.max(max, bfs(i,j));
	            }
	        }
	    }
	    
	    System.out.println(max);
	}
	
	private static int[][] divide(int num) {
	    int[][] tmp = new int[len][len];
	    
	    int tmpLen = (int)Math.pow(2,num);
	    
	    for(int i = 0 ; i < len ; i += tmpLen) {
	        for(int j = 0 ; j < len ; j += tmpLen) {
	            rotate(i, j, tmpLen, tmp);
	        }
	    }
	    
	    return tmp;
	}
	
	private static void rotate(int r, int c, int v, int[][] tmp) {
	    for(int i = 0 ; i < v; i++) {
	        for(int j = 0 ; j < v ; j++) {
	            tmp[r + i][c + j] = A[r + v - 1 - j][c + i];
	        }
	    }
	}
	
	private static int[][] melt() {
	    int[][] tmp = new int[len][len];
	    for(int i = 0 ; i < len ; i++) {
	        for(int j = 0 ; j < len ; j++)
	            tmp[i][j] = A[i][j];
	    }
	    
	    for(int i = 0 ; i < len ; i++) {
	        for(int j = 0 ; j < len ; j++) {
	            if(A[i][j] == 0)  continue;
	            
	            int cnt = 0;
	            
	            for(int d = 0 ; d < 4 ; d++) {
	                int nr = i + dr[d];
	                int nc = j + dc[d];
	                
	                if(inRange(nr,nc) && A[nr][nc] != 0) {
	                    cnt++;
	                }
	            }
	            
	            if(cnt < 3) {
	                tmp[i][j]--;
	            }
	        }
	    }
	    
	    return tmp;
	}
	
	private static int bfs(int x, int y) {
	    int cnt = 1;
	    
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y});
	    
	    visited[x][y] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nr = now[0] + dr[d];
	            int nc = now[1] + dc[d];
	            
	            if(!inRange(nr,nc)) continue;
	            
	            if(!visited[nr][nc] && A[nr][nc] != 0) {
	                visited[nr][nc] = true;
	                q.add(new int[] {nr, nc});
	                cnt++;
	            }
	        }
	    }
	    
	    return cnt;
	}
	
	private static boolean inRange(int r, int c) {
	    return 0 <= r && r < len && 0 <= c && c < len;
	}
}

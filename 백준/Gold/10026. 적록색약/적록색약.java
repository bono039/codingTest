import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N;
    static char[][] map;
    static boolean[][] visited1, visited2;
    static int p1, p2;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    map = new char[N][N];
	    for(int i = 0 ; i < N ; i++) {
	        char[] ch = br.readLine().toCharArray();
	        for(int j = 0 ; j < N ; j++) {
	            map[i][j] = ch[j];
	        }
	    }
	    
	    visited1 = new boolean[N][N];
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(!visited1[i][j]) {
	                bfs1(i, j, map[i][j]);
	                p1++;
	            }
	        }
	    }
	    
	    visited2 = new boolean[N][N];
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(!visited2[i][j]) {
	                bfs2(i, j, map[i][j]);
	                p2++;
	            }
	        }
	    }	    
	    
	    System.out.println(p1 + " " + p2);
	}
	
	private static void bfs1(int x, int y, char c) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y});
	    
	    visited1[x][y] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= N)  continue;
	            
	            if(!visited1[nx][ny] && map[nx][ny] == c) {
	                visited1[nx][ny] = true;
	                q.add(new int[] {nx, ny});
	            }
	        }
	    }
	}
	
	private static void bfs2(int x, int y, char c) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {x, y});
	    
	    visited2[x][y] = true;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited2[nx][ny])  continue;
	            
	            if(c == 'R' || c == 'G') {
    	            if(map[nx][ny] == 'R' || map[nx][ny] == 'G') {
    	                visited2[nx][ny] = true;
    	                q.add(new int[] {nx, ny});
    	            }
	            }
	            else {  // B
	                if(map[nx][ny] == c) {
	                    visited2[nx][ny] = true;
	                    q.add(new int[]{nx, ny});
	                }
	            }
	        }
	    }
	}
}

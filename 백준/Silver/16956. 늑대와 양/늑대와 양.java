import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int R,C;
    static char[][] map;
    static boolean canGo = false;
    
    static Queue<int[]> q = new ArrayDeque<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    
	    map = new char[R][C];
	    
	    for(int i = 0 ; i < R ; i++) {
	        char[] ch = br.readLine().toCharArray();
	        for(int j = 0 ; j < C ; j++) {
	            map[i][j] = ch[j];
	            
	            if(map[i][j] == 'W')   q.add(new int[] {i,j});
	        }
	    }
	    
	    bfs();
	    
	    if(canGo) {
	        System.out.println(0);
	        return;
	    }
	    
	    System.out.println(1);
	    
	    for(int i = 0 ; i < R ; i++) {
	        for(int j = 0 ; j < C ; j++) {
	            System.out.print(map[i][j]);
	        }
	        System.out.println();
	    }
	}
	
	private static void bfs() {
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
	                if(map[nx][ny] == '.') {
	                    map[nx][ny] = 'D';
	                }
	                if(map[nx][ny] == 'S') {
	                    canGo = true;
	                    return;
	                }
	            }
	        }
	    }
	}
}

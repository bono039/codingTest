import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    static int map[][];
    static int aparts[] = new int[25*25];
    static int apartNum = 0;
    static boolean visited[][];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
		    String str = br.readLine();
		    for(int j = 0 ; j < N ; j++) {
		        map[i][j] = str.charAt(j) - '0';
		    }
		}
		
		visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < N ; j++) {
		        if(map[i][j] != 0 && !visited[i][j]) {
		            apartNum++;
		            BFS(i, j);
		        }
		    }
		}
		
		Arrays.sort(aparts);
		System.out.println(apartNum);
		
		for(int i = 0 ; i < aparts.length ; i++) {
		    if(aparts[i] == 0) continue;
		    System.out.println(aparts[i]);
		}
	}
	
	public static void BFS(int i, int j) {
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[]{i, j});
	    visited[i][j] = true;
	    aparts[apartNum]++;
	    
	    while(!queue.isEmpty()) {
	        int[] now = queue.poll();
	        
	        int x = now[0];
	        int y = now[1];
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = x + dx[d];
	            int ny = y + dy[d];
	            
	            if(0 <= nx && nx < N  && 0 <= ny && ny < N) {
	                if(!visited[nx][ny] && map[nx][ny] != 0) {
	                    queue.add(new int[]{nx, ny});
	                    visited[nx][ny] = true;
	                    aparts[apartNum]++;
	                }
	            }
	        }
	    }
	}
}
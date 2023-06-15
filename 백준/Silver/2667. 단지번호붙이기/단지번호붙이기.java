import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    static int N;
    static char[][] map;
    static boolean[][] visited;
    
    static int[] house = new int[25*25];
    static int houseNum = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
		    char[] ch = br.readLine().toCharArray();
		    for(int j = 0 ; j < ch.length ; j++) {
		        map[i][j] = ch[j];
		    }
		}
		
		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < N ; j++) {
		        if(!visited[i][j] && map[i][j] == '1') {
		            houseNum++;
		            dfs(i, j);
		        }
		    }
		}
		
		Arrays.sort(house);
		System.out.println(houseNum);
		
		for(int h : house) {
		    if(h == 0) continue;
		    sb.append(h).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int a, int b) {
	    if(visited[a][b]) return;
	    
	    visited[a][b] = true;
	    house[houseNum]++;
	    
	    for(int d = 0 ; d < 4 ; d++) {
	        int x = a + dx[d];
	        int y = b + dy[d];
	        
	        if(0 <= x && x < N && 0 <= y && y < N) {
    	        if(map[x][y] == '1' && !visited[x][y]) {
    	            dfs(x, y);
    	        }	            
	        }
	    }
	}
}
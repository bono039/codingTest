import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static int N, M, R;
    static int min;
    static int[][] map;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 0 ; j < M ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		min = Math.min(N, M);
		
		while(R --> 0) {
		    rotate();
		}

		print();
	}
	
	private static void rotate() {
	    for(int i = 0 ; i < min / 2 ; i++) {
	        int x = i;
	        int y = i;
	        
	        int lastVal = map[x][y];
	        
	        int idx = 0;
	        
	        while(idx < 4) {
	            int nx = x + dx[idx];
	            int ny = y + dy[idx];
	            
	            if(i <= nx && nx < N - i && i <= ny && ny < M - i) {
	                map[x][y] = map[nx][ny];
    	            x = nx;
    	            y = ny; 
	            }
	            else {
	                idx++;
	            }
	        }
	        
	        map[i + 1][i] = lastVal;
	    }
	}
	
	private static void print() {
	    StringBuilder sb = new StringBuilder();
	    
		for(int[] i : map) {
		    for(int j : i) {
		        sb.append(j + " ");
		    }
		    sb.append("\n");
		}
		System.out.println(sb);	    
	}
}

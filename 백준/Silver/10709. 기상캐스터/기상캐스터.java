import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int H,W;
    static char[][] map;
    static int[][] dist;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    H = Integer.parseInt(st.nextToken());
	    W = Integer.parseInt(st.nextToken());
	    
	    map = new char[H][W];
	    dist = new int[H][W];
	    
	    for(int i = 0 ; i < H ; i++) {
	        char[] ch = br.readLine().toCharArray();
	        for(int j = 0 ; j < W ; j++) {
	            map[i][j] = ch[j];
	            dist[i][j] = -1;
	        }
	    }
	    
	    for(int i = 0 ; i < H ; i++) {
	        int cy = 0;
	        boolean exists = false;
	        
	        for(int j = 0 ; j < W ; j++) {
	            if(map[i][j] == 'c') {
	                cy = j;
	                dist[i][j] = 0;
	                exists = true;
	            }
	            else {
	                if(exists) {
	                    dist[i][j] = j - cy;
	                }
	            }
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0 ; i < H ; i++) {
	        for(int j = 0 ; j < W ; j++) {
	            sb.append(dist[i][j]).append(" ");
	        }
	        sb.append("\n");
	    }
	    System.out.println(sb.toString());
	}
}

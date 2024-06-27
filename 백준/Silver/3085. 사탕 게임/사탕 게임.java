import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static int max = 1;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    map = new char[N][N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        String s = br.readLine();
	        for(int j = 0 ; j < N ; j++) {
	            map[i][j] = s.charAt(j);
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N-1 ; j++) {
	            if(map[i][j] != map[i][j+1]) {
	                swap(i, j, i, j+1);
	                calc();
	                swap(i, j, i, j+1);
	            }
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N-1 ; j++) {
	            if(map[j][i] != map[j+1][i]) {
	                swap(j, i, j+1, i);
	                calc();
	                swap(j, i, j+1, i);
	            }
	        }
	    }
	    
	    System.out.println(max);
	}
	
	private static void swap(int x1, int y1, int x2 ,int y2) {
	    char tmp = map[x1][y1];
	    map[x1][y1] = map[x2][y2];
	    map[x2][y2] = tmp;
	}
	
	private static void calc() {
	    for(int i = 0 ; i < N ; i++) {
	        int cnt = 1;
	        
	        for(int j = 0 ; j < N-1 ; j++) {
	            if(map[i][j] == map[i][j+1]) {
	                cnt++;
	                max = Math.max(max, cnt);
	            }
	            else {
	                cnt = 1;
	            }
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        int cnt = 1;
	        
	        for(int j = 0 ; j < N-1 ; j++) {
	            if(map[j][i] == map[j+1][i]) {
	                cnt++;
	                max = Math.max(max, cnt);
	            }
	            else {
	                cnt = 1;
	            }
	        }
	    }
	}
}
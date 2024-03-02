import java.util.*;
import java.io.*;

public class Main {
    static int N,M,R;
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
	        for(int j = 0 ; j < M ; j++)
	            map[i][j] = Integer.parseInt(st.nextToken());
	    }
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < R ; i++) {
	        int num = Integer.parseInt(st.nextToken());
	        
	        if(num == 1)    move1();
	        else if(num == 2)   move2();
	        else if(num == 3)   move3();
	        else if(num == 4)   move4();
	        else if(num == 5)   move5();
	        else if(num == 6)   move6();
	    }
	    
		print();
	}
	
	private static void move1() {
	    int len1 = map.length;
	    int len2 = map[0].length;
	    
	    int[][] tmp = new int[len1][len2];
	    
	    for(int i = 0 ; i < len1 ; i++)
	        for(int j = 0 ; j < len2 ; j++)
	            tmp[len1 - 1 - i][j] = map[i][j];
	            
	    for(int i = 0 ; i < len1 ; i++)
	        for(int j = 0 ; j < len2 ; j++)
	            map[i][j] = tmp[i][j];
	}
	
	private static void move2() {
	    int len1 = map.length;
	    int len2 = map[0].length;
	    
	    int[][] tmp = new int[len1][len2];
	    
	    for(int i = 0 ; i < len1 ; i++)
	        for(int j = 0 ; j < len2 ; j++)
	            tmp[i][len2 - 1 - j] = map[i][j];
	            
	    map = tmp.clone();
	}
	
	private static void move3() {
	    int len1 = map.length;
	    int len2 = map[0].length;
	    
	    int[][] tmp = new int[len2][len1];
	    for(int i = 0 ; i < len1 ; i++)
	        for(int j = 0 ; j < len2 ; j++)
	            tmp[j][len1 - 1 - i] = map[i][j];
	            
        map = tmp.clone();
	}

	private static void move4() {
	    int len1 = map.length;
	    int len2 = map[0].length;
	    
	    int[][] tmp = new int[len2][len1];
	    
	    for(int i = 0 ; i < len1 ; i++)
	        for(int j = 0 ; j < len2 ; j++)
	            tmp[len2 - 1 - j][i] = map[i][j];
	            
        map = tmp.clone();
	}
	
	private static void move5() {
	    int r = map.length;
	    int c = map[0].length;
	    
	    int[][] tmp = new int[r][c];
	    for(int i = 0 ; i < r/2 ; i++) {
	        for(int j = 0 ; j < c/2 ; j++)
	            tmp[i][j + c/2] = map[i][j];
	    }
	      
	    for(int i = 0 ; i < r/2 ; i++) {
	        for(int j = c/2 ; j < c ; j++)
	            tmp[i + r/2][j] = map[i][j]; 
	    }
	    
	    for(int i = r/2 ; i < r ; i++) {
	        for(int j = c/2 ; j < c ; j++)
	            tmp[i][j - c/2] = map[i][j];
	    }
	    
	    for(int i = r/2 ; i < r ; i++) {
	        for(int j = 0 ; j < c/2 ; j++)
	            tmp[i - r/2][j] = map[i][j];
	    }
	    
	    map = tmp.clone();
	}
	
	private static void move6() {
	    int r = map.length;
	    int c = map[0].length;
	    
	    int[][] tmp = new int[r][c];
	    
	    for(int i = 0 ; i < r/2 ; i++) {
	        for(int j = 0 ; j < c/2 ; j++)
	            tmp[i + r/2][j] = map[i][j];
	    }
	    
	    for(int i = 0 ; i < r/2 ; i++) {
	        for(int j = c/2 ; j < c ; j++)
	            tmp[i][j - c/2] = map[i][j];
	    }
	    
	    for(int i = r/2 ; i < r ; i++) {
	        for(int j = c/2 ; j < c ; j++)
	            tmp[i - r/2][j] = map[i][j];
	    }
	    
	    for(int i = r/2 ; i < r ; i++) {
	        for(int j = 0 ; j < c/2 ; j++)
	            tmp[i][j + c/2] = map[i][j];
	    }
	    
	    map = tmp.clone();
	}	
	
	private static void print() {
	    StringBuilder sb = new StringBuilder();
	    
	    for(int[] i : map) {
	        for(int j : i) {
	            sb.append(j + " ");
	        }
	        sb.append("\n");
	    }
	        
	    System.out.println(sb.toString());
	}
}

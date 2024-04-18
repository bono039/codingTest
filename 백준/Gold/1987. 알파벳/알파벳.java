import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int R,C;
    static int[][] board;
    static boolean[] alphabet = new boolean[26];    
    static int max = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    
	    board = new int[R][C];	    
	    for(int i = 0 ; i < R ; i++) {
	        char[] ch = br.readLine().toCharArray();
	        for(int j = 0 ; j < C ; j++) {
	            board[i][j] = ch[j] - 'A';
	        }
	    }
	    
	    alphabet[board[0][0]] = true;
	    dfs(0,0,1);
	    System.out.println(max);
	}
	
	private static void dfs(int x, int y, int cnt) {
	    max = Math.max(max, cnt);
	    
	    for(int d = 0 ; d < 4 ; d++) {
	        int nx = x + dx[d];
	        int ny = y + dy[d];
	        
	        if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
	            if(!alphabet[board[nx][ny]]) {
	                alphabet[board[nx][ny]] = true;
	                dfs(nx, ny, cnt + 1);
	                alphabet[board[nx][ny]] = false;
	            }
	        }
	    }
	}
}

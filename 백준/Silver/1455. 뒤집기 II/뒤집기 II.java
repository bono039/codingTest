import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int answer = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    board = new int[N][M];
	    for(int i = 0 ; i < N ; i++) {
	        String str = br.readLine();
	        for(int j = 0 ; j < M ; j++) {
	            board[i][j] = str.charAt(j) - '0';
	        }
	    }
	    
	    for(int i = M-1 ; i >= 0 ; i--) {
	        for(int j = N-1 ; j >= 0 ; j--) {
	            if(board[j][i] == 1) {
	                flip(j, i);
	                
	                answer++;
	            }
	        }
	    }
	    
	    System.out.println(answer);
	}
	
	private static void flip(int a, int b) {
	    for(int i = 0 ; i <= a ; i++) {
	        for(int j = 0 ; j <= b ; j++) {
	            if(board[i][j] == 1) board[i][j] = 0;
	            else                 board[i][j] = 1;
	        }
	    }
	}
}

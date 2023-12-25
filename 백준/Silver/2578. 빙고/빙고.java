import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int bingo = 0;
    static int turn = 1;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    board = new int[5][5];
	    for(int i = 0 ; i < 5 ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < 5 ; j++) {
	            board[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i = 0 ; i < 5 ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < 5 ; j++) {
	            int num = Integer.parseInt(st.nextToken());
	            
	            for(int a = 0 ; a < 5 ; a++) {
	                for(int b = 0 ; b < 5 ; b++) {
	                    if(board[a][b] == num) {
	                        board[a][b] = 0;
	                    }
	                }
	            }
	            
	            rCheck();
	            cCheck();
	            lrCheck();
	            rlCheck();
	            
	            if(bingo >= 3) {
	                System.out.println(turn);
	                return;
	            }
	            
	            bingo = 0;
	            turn++;
	        }
	    }
	}
	
	private static void rCheck() {
	    for(int i = 0 ; i < 5 ; i++) {
	        int zeroCnt = 0;
	        for(int j = 0 ; j < 5 ; j++) {
	            if(board[i][j] == 0)
	                zeroCnt++;
	        }
	        
	        if(zeroCnt == 5)
	            bingo++;
	    }
	}
	
	private static void cCheck() {
	    for(int i = 0 ; i < 5 ; i++) {
	        int zeroCnt = 0;
	        for(int j = 0 ; j < 5 ; j++) {
	            if(board[j][i] == 0)
	                zeroCnt++;
	        }
	        
	        if(zeroCnt == 5)
	            bingo++;
	    }
	}
	
	private static void lrCheck() {
	    int zeroCnt = 0;
	    for(int i = 0 ; i < 5 ; i++) {
	        if(board[i][i] == 0)
	            zeroCnt++;
	    }
	    
	    if(zeroCnt == 5) {
	        bingo++;
	    }
	}
	
	private static void rlCheck() {
	    int zeroCnt = 0;
	    for(int i = 0 ; i < 5 ; i++) {
	        if(board[i][4 - i] == 0)
	            zeroCnt++;
	    }
	    if(zeroCnt == 5) {
	        bingo++;
	    }
	}
}

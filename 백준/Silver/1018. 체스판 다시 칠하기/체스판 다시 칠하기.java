import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		String[] board = new String[row];
		for(int i = 0 ; i < row ; i++) {
		    board[i] = br.readLine();
		}
		
		int sol = Integer.MAX_VALUE;
		for(int i = 0 ; i <= row - 8 ; i++) {
		    for(int j = 0 ; j <= col - 8 ; j++) {
        		int curSol = getSolution(i, j, board);
        		if(sol > curSol) sol = curSol;
		    }
		}
		
        System.out.println(sol);
        br.close();
	}
	
	private static int getSolution(int sRow, int sCol, String[] board) {
	    String[] ansBoard = {"WBWBWBWB", "BWBWBWBW"};
	    int whiteSol = 0;
	    
	    for(int i = 0 ; i < 8 ; i++) {
	        int row = sRow + i;
	        
	        for(int j = 0 ; j < 8 ; j++) {
	            int col = sCol + j;
	            
	            if(board[row].charAt(col) != ansBoard[row % 2].charAt(j))
	                whiteSol++;
	        }
	    }
	    return Math.min(whiteSol, 64 - whiteSol);
	}
}
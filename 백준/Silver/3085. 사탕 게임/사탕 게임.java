import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;
    static int N;
    static int max = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for(int i = 0 ; i < N ; i++) {
		    String str = br.readLine();
		    for(int j = 0 ; j < board[i].length ; j++) {
		        board[i][j] = str.charAt(j);
		    }
		}
		
		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < N - 1 ; j++) {
		        char tmp = board[i][j];
		        board[i][j] = board[i][j + 1];
		        board[i][j + 1] = tmp;
		        
		        search();

		        tmp = board[i][j];
		        board[i][j] = board[i][j + 1];
		        board[i][j + 1] = tmp;
		    }
		}
		
		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < N - 1 ; j++) {
		        char tmp = board[j][i];
		        board[j][i] = board[j + 1][i];
		        board[j + 1][i] = tmp;
		        
		        search();
		        
		        tmp = board[j][i];
		        board[j][i] = board[j + 1][i];
		        board[j + 1][i] = tmp;	        
		    }
		}
		
		System.out.println(max);
		br.close();
	}
	
	public static void swap(char a, char b) {
	    char tmp = a;
	    a = b;
	    b = tmp;
	}
	
	public static void search() {
	    for(int i = 0 ; i < N ; i++) {
	        int cnt = 1;
	        for(int j = 0 ; j < N - 1 ; j++) {
	            if(board[i][j] == board[i][j + 1])
	                cnt++;
	            else
	                cnt = 1;
	                
	            max = Math.max(max, cnt);
	        }
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        int cnt = 1;
	        for(int j = 0 ; j < N - 1 ; j++) {
	            if(board[j][i] == board[j + 1][i])
	                cnt++;
	            else
	                cnt = 1;
	                
	            max = Math.max(max, cnt);
	        }
	    }
	}
}
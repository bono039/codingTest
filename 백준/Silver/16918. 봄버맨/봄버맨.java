import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int R,C,N;
    static char[][] board;
    static int[][] timeArr;
    static int time;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    board = new char[R][C];
	    timeArr = new int[R][C];
	    
	    for(int i = 0 ; i < R ; i++) {
	        char[] ch = br.readLine().toCharArray();
	        for(int j = 0 ; j < C ; j++) {
	            board[i][j] = ch[j];
	            
	            if(board[i][j] == 'O')
	                timeArr[i][j] = 3;
	        }
	    }
	    
	    time = 1;
	    while(time <= N) {
	        if(time % 2 == 0) {
	            installBombs();
	        }
	        else if(time % 2 == 1) {
	            boom();
	        }
	        
	        time++;
	    }
	    
	    printArray();
	}
	
	private static void installBombs() {
	    for(int i = 0 ; i < R ; i++) {
	        for(int j = 0 ; j < C ; j++) {
	            if(board[i][j] == '.') {
	                board[i][j] = 'O';
	                timeArr[i][j] = time + 3;
	            }
	        }
	    }
	}
	
	private static void boom() {
	    for(int i = 0 ; i < R ; i++) {
	        for(int j = 0 ; j < C ; j++) {
	            if(timeArr[i][j] == time) {
	                board[i][j] = '.';
	                
	                for(int d = 0 ; d < 4 ; d++) {
        	            int nx = i + dx[d];
        	            int ny = j + dy[d];
        	            
        	            if(nx < 0 || nx >= R || ny < 0 || ny >= C)  continue;
                        if(board[nx][ny] == 'O' && timeArr[nx][ny] != time) {
                            board[nx][ny] = '.';
                            timeArr[nx][ny] = 0;
                        }
        	        }
	            }
	        }
	    }
	}
	
	private static void printArray() {
	    StringBuilder sb = new StringBuilder();
	    for(char[] ch : board) {
	        for(char c : ch) {
	            sb.append(c);
	        }
	        sb.append("\n");
	    }
	    System.out.println(sb.toString());	    
	}
}

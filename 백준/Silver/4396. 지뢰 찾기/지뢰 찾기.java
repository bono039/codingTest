import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1, -1, -1, 1, 1};
    static int[] dy = {1,-1,0,0, -1, 1, 1, -1};
    
    static int N;
    static char[][] board;
    static boolean[][] visited;
    static int[][]  ans;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
		
    	N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		ans = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
		    String str = br.readLine();
		    for(int j = 0 ; j < N ; j++) {
		        board[i][j] = str.charAt(j);
		    }
		}
		
		boolean isBombTouched = false;
		for(int i = 0 ; i < N ; i++) {
		    String str = br.readLine();
		    for(int j = 0 ; j < N ; j++) {
		        char ch = str.charAt(j);
		        
		        if(ch == 'x') {
		            if(board[i][j] == '.') {
		                visited[i][j] = true;
		                fillAround(i, j);
		            }
		            else {
		                isBombTouched = true;
		            }
		        }
		        
		    }
		}
	
	    // 출력하기
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(!isBombTouched) {
	                if(visited[i][j]) {
	                    sb.append(ans[i][j]);
	                }
	                else {
	                    sb.append(".");
	                }
	            }
	            else {
	                if(visited[i][j]) {
	                    sb.append(ans[i][j]);
	                }
	                else {
	                    if(board[i][j] == '*') {
	                        sb.append('*');
	                    }
	                    else {
	                        sb.append(".");
	                    }
	                }
	            }
	        }
	        sb.append("\n");
	    }
	    System.out.println(sb);
	}
	
    private static void fillAround(int x, int y) {
        for(int d = 0 ; d < 8 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(!inRange(nx, ny))    continue;
            
            if(board[nx][ny] == '*') {
                ans[x][y]++;
            }
        }
    }
    
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};   // 반시계 방향
    static int[] dy = {1, 0, -1, 0};
    
    static int N, M, R;
    static int[][] board;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    
	    board = new int[N][M];
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            board[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    while(R --> 0) {
	        rotate();
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int[] i : board) {
	        for(int j : i) {
	            sb.append(j + " ");
	        }
	        sb.append("\n");
	    }
	    System.out.println(sb);
	}
	
	private static void rotate() {
	    for(int i = 0 ; i < Math.min(N, M) / 2 ; i++) {
	        int x = i;
	        int y = i;
	        
	        int lastVal = board[x][y];
	        
	        int idx = 0;
	        while(idx < 4) {
	            int nx = x + dx[idx];
                int ny = y + dy[idx];
                
                if(!inRange(i, nx, ny)) {
                    idx++;
                }
                else {
                    board[x][y] = board[nx][ny];
                    x = nx;
                    y = ny;
                }
	        }
	        
	        board[x + 1][y] = lastVal;
	    }
	}
	
	private static boolean inRange(int i, int x, int y) {
	    return (i <= x && x < N - i && i <= y && y < M - i);
	}
}

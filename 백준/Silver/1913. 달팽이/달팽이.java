import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int N, findNum;
    static int[][] map;
    
    static int[] pos = {0, 0};
    static int[] ans = new int[2];
    static int dir = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		findNum = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		map[0][0] = N * N;
		
		for(int i = N * N - 1 ; i >= 1 ; i--) {
		    int nx = pos[0] + dx[dir];
	        int ny = pos[1] + dy[dir];
	        
		    if(!inRange(nx, ny) || (map[nx][ny] != 0)) {
		        dir = (dir + 1) % 4;
		    }
		    
	        pos[0] += dx[dir];
	        pos[1] += dy[dir];
		    
	        map[pos[0]][pos[1]] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < N ; j++) {
		        sb.append(map[i][j] + " ");
		        
		        if(map[i][j] == findNum) {
		            ans = new int[]{i + 1, j + 1};
		        }
		    }
		    sb.append("\n");
		}
		
		sb.append(ans[0] + " " + ans[1]);
		
		System.out.println(sb);
	}
	
	private static boolean inRange(int x, int y) {
	    return (0 <= x && x < N && 0 <= y && y < N);
	}
}

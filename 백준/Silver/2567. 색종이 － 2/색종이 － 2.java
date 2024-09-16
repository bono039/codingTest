import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int[][] paper = new int[101][101];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
    	int N = Integer.parseInt(br.readLine());	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        
	        for(int a = x ; a < x+10 ; a++) {
	            for(int b = y ; b < y+10 ; b++) {
	                paper[a][b] = 1;
	            }
	        }
	    }
	    
	    int cnt = 0;
	    for(int i = 1 ; i <= 100 ; i++) {
	        for(int j = 1 ; j <= 100 ; j++) {
	            if(paper[i][j] == 1) {
	                for(int d = 0 ; d < 4 ; d++) {
	                    int nx = i + dx[d];
	                    int ny = j + dy[d];
	                    
	                    if(inRange(nx, ny) && paper[nx][ny] == 0)
	                        cnt++;
	                    else if(!inRange(nx, ny))
	                        cnt++;
	                }
	            }
	        }
	    }
	    
	    System.out.println(cnt);
	}
	
	private static boolean inRange(int x, int y) {
	    return x >= 1 && x <= 100 && y >= 1 && y <= 100;
	}
}
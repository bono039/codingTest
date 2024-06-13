import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N;
    static char[][] map;
    static List<int[]> list = new ArrayList<>();
    
    static int x, y, wLen, lArm, rArm, lLeg, rLeg;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    map = new char[N][N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        char[] ch = br.readLine().toCharArray();
	        
	        for(int j = 0 ; j < ch.length ; j++) {
	            map[i][j] = ch[j];
	            
	            if(map[i][j] == '*')
	                list.add(new int[]{i,j});
	        }
	    }
	    
	    for(int[] pos : list) {
	        if(isHeart(pos[0], pos[1])) {
	            x = pos[0];
	            y = pos[1];
	            break;
	        }
	    }
	    
	    int n1 = x;
	    int n2 = y-1;
	    while(inRange(n1,n2) && map[n1][n2] == '*') {
	        lArm++;
	        n2--;
	    }
	    
	    n1 = x;
	    n2 = y+1;
	    while(inRange(n1,n2) && map[n1][n2] == '*') {
	        rArm++;
	        n2++;
	    }
	    
	    int wx = x+1;
	    int wy = y;
	    while(inRange(wx,wy) && map[wx][wy] == '*') {
	        wLen++;
	        wx++;
	    }

	    n1 = wx + 1;
	    n2 = wy - 1;
	    lLeg = 1;
	    while(inRange(n1,n2) && map[n1][n2] == '*') {
	        lLeg++;
	        n1++;
	    }
	    
	    n1 = wx + 1;
	    n2 = wy + 1;
	    rLeg = 1;
	    while(inRange(n1,n2) && map[n1][n2] == '*') {
	        rLeg++;
	        n1++;
	    }
	    
	    System.out.println((x+1) + " " + (y+1));
	    System.out.println(lArm + " " + rArm + " " + wLen + " " + lLeg + " " + rLeg);    // 행, 열
	}
	
	private static boolean isHeart(int r, int c) {
	    for(int d = 0 ; d < 4 ; d++) {
	        int nr = r + dx[d];
	        int nc = c + dy[d];
	        
	        if(!inRange(nr, nc))
	            return false;
	            
	        if(map[nr][nc] != '*')  
	            return false;
	    }
	    return true;
	}
	
	private static boolean inRange(int r, int c) {
	    return 0 <= r && r < N && 0 <= c && c < N;
	}
}

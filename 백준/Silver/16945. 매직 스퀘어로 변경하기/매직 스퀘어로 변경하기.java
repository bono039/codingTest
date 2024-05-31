import java.util.*;
import java.io.*;

public class Main {
    static int[][] A;
    static boolean[] chk = new boolean[10];
    static int answer = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    A = new int[3][3];
	    for(int i = 0 ; i < 3 ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < 3 ; j++) {
	            A[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    dfs(0,0);
	    System.out.println(answer);
	}
	
	private static void dfs(int depth, int sum) {
	    if(depth == 9 && isMagicSquare()) {
	        answer = Math.min(answer, sum);
	        return;
	    }
	    
	    int x = depth/3;
	    int y = depth%3;
	    
	    for(int i = 1 ; i <= 9 ; i++) {
	        if(!chk[i]) {
	            int tmp = A[x][y];
	            
	            chk[i] = true;
	            A[x][y] = i;
	            
	            dfs(depth + 1, sum + Math.abs(tmp - i));
	            
	            chk[i] = false;
	            A[x][y] = tmp;
	        }
	    }
	}
	
	private static boolean isMagicSquare() {
	    int rSum0 = A[0][0] + A[0][1] + A[0][2];
	    int rSum1 = A[1][0] + A[1][1] + A[1][2];
	    int rSum2 = A[2][0] + A[2][1] + A[2][2];
	    
	    int cSum0 = A[0][0] + A[1][0] + A[2][0];
	    int cSum1 = A[0][1] + A[1][1] + A[2][1];
	    int cSum2 = A[0][2] + A[1][2] + A[2][2];
	    
	    int dSum0 = A[0][0] + A[1][1] + A[2][2];
	    int dSum1 = A[0][2] + A[1][1] + A[2][0];
	    
	    if(rSum0 != 15 || rSum1 != 15 || rSum2 != 15)   return false;
	    if(cSum0 != 15 || cSum1 != 15 || cSum2 != 15)   return false;
	    if(dSum0 != 15 || dSum1 != 15)   return false;
	    
	    return true;
	}
}

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] chk;
    
    static int min = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    S = new int[N][N];
	    chk = new boolean[N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < N ; j++) {
	            S[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    dfs(0);	    
	    System.out.println(min);
	}
	
	private static void dfs(int cnt) {
	    if(cnt == N) {
	        int start = 0;
	        int link = 0;
	        
	        for(int i = 0 ; i < N ; i++) {
	            for(int j = i + 1 ; j < N ; j++) {
	                if(chk[i] != chk[j])   continue;
	                
	                if(chk[i])  start += S[i][j] + S[j][i];
	                else        link += S[i][j] + S[j][i];
	            }
	        }
	        min = Math.min(min, Math.abs(start - link));
	        return;
	    }

        chk[cnt] = true;
        dfs(cnt + 1);
        
        chk[cnt] = false;
        dfs(cnt + 1);
	}
}

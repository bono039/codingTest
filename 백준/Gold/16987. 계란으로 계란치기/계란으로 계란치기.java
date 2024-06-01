import java.util.*;
import java.io.*;

public class Main {
    static int N, answer;
    static int[] S,W;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    S = new int[N];
	    W = new int[N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        S[i] = Integer.parseInt(st.nextToken());
	        W[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    dfs(0, 0);
	    System.out.println(answer);
	}
	
	private static void dfs(int depth, int cnt) {
	    if(depth == N) {
	        answer = Math.max(answer, cnt);
	        return;
	    }
	    
	    if(S[depth] <= 0 || cnt == N-1) {
	        dfs(depth + 1, cnt);
	        return;
	    }
	    
	    int tmpCnt = cnt;
	    
        for(int i = 0 ; i < N ; i++) {
            if(i == depth || S[i] <= 0) continue;
            
            S[i] -= W[depth];
            S[depth] -= W[i];
            
            if(S[depth] <= 0)   cnt++;
            if(S[i] <= 0)   cnt++;
            
            dfs(depth + 1, cnt);
            
            S[i] += W[depth];
            S[depth] += W[i];
            cnt = tmpCnt;
        }
	}
}

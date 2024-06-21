import java.util.*;
import java.io.*;

public class Main {
    static int N,Q;
    static int[] duck;
    static boolean[] chk;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    Q = Integer.parseInt(st.nextToken());
        
	    duck = new int[Q];
	    for(int i = 0 ; i < Q ; i++) {
	        duck[i] = Integer.parseInt(br.readLine());
	    }

        chk = new boolean[N+1];
	    for(int i = 0 ; i < Q ; i++) {
	        solve(duck[i]);
	    }
	    System.out.println(sb.toString());
	}
	
	private static void solve(int num) {
	    int idx = num;
	    int ans = 0;
	    
	    while(idx != 0) {
	        if(chk[idx]) {
	            ans = idx;
	        }
	        idx /= 2;
	    }
	    
	    sb.append(ans).append("\n");
	    
	    if(ans == 0)
	        chk[num] = true;
	}
}
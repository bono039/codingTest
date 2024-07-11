import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] goalArr;
    static int min = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    String now = br.readLine();
	    String goal = br.readLine();
	    
	    boolean[] b1 = new boolean[N];
	    boolean[] b2 = new boolean[N];
	    goalArr = new boolean[N];
	    	    
	    for(int i = 0 ; i < N ; i++) {
	        b1[i] = now.charAt(i) != '0';
	        b2[i] = now.charAt(i) != '0';
	        goalArr[i] = goal.charAt(i) != '0';
	    }
	    
	    greedy(1, 0, b1);
	    greedy(1, 1, useSwitch(0, b2));
	    
	    System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	private static void greedy(int idx, int cnt, boolean[] b) {
	    if(idx == N) {
	        if(b[idx-1] == goalArr[idx-1]) {
	            min = Math.min(min, cnt);
	        }
	        return;
	    }
	    
	    if(b[idx-1] != goalArr[idx-1])
	        greedy(idx+1, cnt+1, useSwitch(idx, b));
	    else
	        greedy(idx+1, cnt, b);
	}
	
	private static boolean[] useSwitch(int idx, boolean[] b) {
	    for(int i = idx-1 ; i <= idx+1 ; i++) {
	        if(0 <= i && i < N)
	            b[i] = !b[i];
	    }
	    
	    return b;
	}
}
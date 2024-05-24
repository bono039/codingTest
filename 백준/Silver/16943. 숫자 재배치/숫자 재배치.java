import java.util.*;
import java.io.*;

public class Main {
    static String[] str;
    static int A,B, N;
    static boolean[] chk;
    static List<Integer> list = new ArrayList<>();
    static int answer = -1;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    str = br.readLine().split(" ");
	    A = Integer.parseInt(str[0]);
	    B = Integer.parseInt(str[1]);
	    
	    N = str[0].length();
	    chk = new boolean[N];
	    dfs(0,0);
	    System.out.println(answer);
	}
	
	private static void dfs(int idx, int depth) {
	    if(depth == N) {
	        StringBuilder tmp = new StringBuilder();
	        for(int i : list) {
	            tmp.append(i);
	        }
	        
	        if(tmp.charAt(0) == '0')    return;
	        
	        int num = Integer.parseInt(tmp.toString());
	        if(num < B) {
	            answer = Math.max(answer, num);
	        }
	        
	        return;
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        if(!chk[i]) {
	            chk[i] = true;
	            list.add(str[0].charAt(i) - '0');
	            dfs(i+1, depth+1);
	            chk[i] = false;
	            list.remove(list.size() - 1);
	        }
	    }
	}
}

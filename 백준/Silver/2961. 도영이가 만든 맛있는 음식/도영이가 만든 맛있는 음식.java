import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 1_000_000_000;
    static int N, S, B;    
    static int[][] arr;
    
    static List<Integer> list = new ArrayList<>();
    static int minDiff = MAX - 1;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    arr = new int[N][2];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int S = Integer.parseInt(st.nextToken());
	        int B = Integer.parseInt(st.nextToken());
	        
	        arr[i][0] = S;
	        arr[i][1] = B;
	    }
        
	    for(int i = 1 ; i <= N ; i++) {
	        dfs(0, 0, i, 1, 0);
	    }
	    
	    System.out.println(minDiff);
	}
	
	private static void dfs(int idx, int cnt, int target, int sour, int bitter) {
	    if(cnt == target) {
	        for(int i = 0 ; i < list.size() ; i++) {
	            int tmpS = arr[list.get(i)][0];
	            int tmpB = arr[list.get(i)][1];
	        }
	        
	        minDiff = Math.min(minDiff, Math.abs(sour - bitter));
	        return;
	    }
	    
	    for(int i = idx ; i < N ; i++) {
	        list.add(i);
	        dfs(i + 1, cnt + 1, target, sour * arr[i][0], bitter + arr[i][1]);
	        list.remove(list.size() - 1);
	    }
	}
}

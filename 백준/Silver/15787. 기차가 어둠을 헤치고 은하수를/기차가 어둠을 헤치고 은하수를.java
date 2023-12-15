import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static Set<String> set = new HashSet<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());   // 기차 수
		M = Integer.parseInt(st.nextToken());   // 명령 수
		
		arr = new int[N + 1][21];
		
		while(M --> 0) {
		    String[] str = br.readLine().split(" ");
		    
		    int cmd = Integer.parseInt(str[0]);
		    int train = Integer.parseInt(str[1]);
		    
		    if(str.length == 2) {
		        move(cmd, train);
		    }
		    else {
		        int seat = Integer.parseInt(str[2]);
		        solve(cmd, train, seat);
		    }
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    StringBuilder sb = new StringBuilder();
		    for(int j = 1 ; j <= 20 ; j++) {
		        sb.append(arr[i][j] + " ");
		    }
		    
		    set.add(sb.toString());
		}
		
		System.out.println(set.size());
	}
	
	private static void solve(int cmd, int train, int seat) {
	    if(cmd == 1) {
	        arr[train][seat] = 1;
	    }
	    else if(cmd == 2) {
	        arr[train][seat] = 0;
	    }
	    
	    return;
	}
	
	private static void move(int cmd, int train) {
	    if(cmd == 3) {  // 모두 한 칸씩 뒤로
    	    for(int i = 20 ; i > 1 ; i--) {
	            arr[train][i] = arr[train][i - 1];
	        }
	        arr[train][1] = 0;
	    }
	    else if(cmd == 4) { // 모두 한 칸씩 앞으로
	        for(int i = 1 ; i < 20 ; i++) {
	            arr[train][i] = arr[train][i + 1];
	        }
	        arr[train][20] = 0;
	    }
	    
	    return;
	}
}

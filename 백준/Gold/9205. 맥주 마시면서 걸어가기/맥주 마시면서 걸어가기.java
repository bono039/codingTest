import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    while(T --> 0) {
	        int N = Integer.parseInt(br.readLine());
	        
	        List<int[]> list = new ArrayList<>();
	        for(int i = 0 ; i < N+2 ; i++) {
	            st = new StringTokenizer(br.readLine(), " ");
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
	            
	            list.add(new int[]{x,y});
	        }
	        
	        boolean[][] flag = new boolean[N+2][N+2];
	        for(int i = 0 ; i < N+2 ; i++) {
	            for(int j = 0 ; j < N+2 ; j++) {
	                int[] now = list.get(i);
	                int[] next = list.get(j);
	                
	                int dist = Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]);
	                
	                if(dist <= 1000)
	                    flag[i][j] = true;
	            }
	        }
	        
	        for(int k = 0 ; k < N+2 ; k++) {
	            for(int i = 0 ; i < N+2 ; i++) {
	                for(int j = 0 ; j < N+2 ; j++) {
	                    if(flag[i][k] && flag[k][j])
	                        flag[i][j] = true;
	                }
	            }
	        }
	        
	        sb.append(flag[0][N+1] ? "happy\n" : "sad\n");
	    }
	    
	    System.out.println(sb.toString());
	}
}
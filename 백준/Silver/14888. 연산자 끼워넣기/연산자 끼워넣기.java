import java.util.*;
import java.io.*;
public class Main {
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] sign = new int[4];
    public static int[] num;
    public static int N;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
		    num[i] = Integer.parseInt(st.nextToken());
		}
		
        st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < 4 ; i++) {
		    sign[i] = Integer.parseInt(st.nextToken());
		}
        
        DFS(num[0], 1);
        
        System.out.println(MAX);
        System.out.println(MIN);
	}
	
	public static void DFS(int n, int idx) {
	    if(idx == N) {
	        MAX = Math.max(MAX, n);
	        MIN = Math.min(MIN, n);
	        return;
	    }
	    
	    for(int i = 0 ; i < 4 ; i++) {
	        if(sign[i] > 0) {
	            sign[i]--;
	            
	            switch(i) {
	                case 0: DFS(n + num[idx], idx + 1); break;
	                case 1: DFS(n - num[idx], idx + 1); break;
	                case 2: DFS(n * num[idx], idx + 1); break;
	                case 3: DFS(n / num[idx], idx + 1); break;
	            }
	            
	            sign[i]++;
	        }
	    }
	}
}
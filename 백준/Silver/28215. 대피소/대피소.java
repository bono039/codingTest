import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] arr;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    arr = new int[N][2];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        arr[i][0] = Integer.parseInt(st.nextToken());
	        arr[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    List<Integer> list = new ArrayList<>();
	    
	    if(K == 1) {
	        for(int i = 0 ; i < N ; i++) {
	            int[] sh = arr[i];
	            
	            int[] dist = new int[N];
	            Arrays.fill(dist, Integer.MAX_VALUE);
	            dist[i] = 0;
	            
	            for(int j = 0 ; j < N ; j++) {
	                if(j == i)  continue;
	                
	                int tmp = Math.abs(sh[0] - arr[j][0]) + Math.abs(sh[1] - arr[j][1]);
	                dist[j] = Math.min(dist[j], tmp);
	            }
	            Arrays.sort(dist);
	            
	            list.add(dist[N - 1]);
	        }
	        
	        System.out.println(Collections.min(list));
	        return;
	    }
	    
	    if(K == 2) {
    	    for(int i = 0 ; i < N - 1 ; i++) {
    	        for(int j = i + 1 ; j < N ; j++) {
    	            int[] h1 = arr[i];
    	            int[] h2 = arr[j];
    	            
    	            int[] dist = new int[N];
    	            Arrays.fill(dist, Integer.MAX_VALUE);
    	            dist[i] = 0;
    	            dist[j] = 0;
    	            
    	            for(int k = 0 ; k < N ; k++) {
    	                if(k == i || k == j)    continue;
    	                
    	                int tmp1 = Math.abs(h1[0] - arr[k][0]) + Math.abs(h1[1] - arr[k][1]);
    	                int tmp2 = Math.abs(h2[0] - arr[k][0]) + Math.abs(h2[1] - arr[k][1]);
	                    dist[k] = Math.min(dist[k], Math.min(tmp1, tmp2));
    	            }
    	            Arrays.sort(dist);
    	            
    	            list.add(dist[N - 1]);
    	        }
    	    }
    	    
    	    System.out.println(Collections.min(list));
    	    return;
	    }
	    
	    if(K == 3) {
    	    for(int i = 0 ; i < N - 2 ; i++) {
    	        for(int j = i + 1 ; j < N - 1 ; j++) {
    	            for(int k = j + 1 ; j < N ; j++) {
    	                // 각 대피소 위치
    	                int[] h1 = arr[i];
    	                int[] h2 = arr[j];
    	                int[] h3 = arr[k];
    	                
    	                int[] dist = new int[N];
        	            Arrays.fill(dist, Integer.MAX_VALUE);
        	            dist[i] = 0;
        	            dist[j] = 0;
        	            dist[k] = 0;
        	            
        	            for(int a = 0 ; a < N ; a++) {
        	                if(a == i || a == j || a == k)    continue;
        	                
        	                int tmp1 = Math.abs(h1[0] - arr[a][0]) + Math.abs(h1[1] - arr[a][1]);
        	                int tmp2 = Math.abs(h2[0] - arr[a][0]) + Math.abs(h1[1] - arr[a][1]);
        	                int tmp3 = Math.abs(h3[0] - arr[a][0]) + Math.abs(h3[1] - arr[a][1]);
    	                    dist[a] = Math.min(dist[a], Math.min(Math.min(tmp1, tmp2), tmp3));
        	            }
        	            Arrays.sort(dist);
        	            
        	            list.add(dist[N - 1]);
    	            }
    	        }
    	    }
    	    
    	    System.out.println(Collections.min(list));
    	    return;	        
	    }
	}
}

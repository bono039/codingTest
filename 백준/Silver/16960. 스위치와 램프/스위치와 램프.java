import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] arr;
    static List<Integer>[] list;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    arr = new int[M+1];
	    list = new ArrayList[N+1];
	    for(int i = 1 ; i <= N ; i++) {
	        list[i] = new ArrayList<>();
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int num = Integer.parseInt(st.nextToken());
	        
	        for(int j = 0 ; j < num ; j++) {
	            int tmp = Integer.parseInt(st.nextToken());
	            list[i].add(tmp);
	            arr[tmp]++;
	        }
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
	        if(isPossible(i)) {
	            System.out.println(1);
	            return;
	        }
	    }
	    System.out.println(0);
	}
	
	private static boolean isPossible(int idx) {
        boolean flag = true;
        
	    for(int x : list[idx]) {
	        arr[x]--;
	        
	        if(arr[x] <= 0) {
	            flag = false;
	        }
	    }
	    
	    for(int x : list[idx]) {
	        arr[x]++;
	    }
	    return flag;
	}
}
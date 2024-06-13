import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    arr = new int[N+1];
	    for(int i = 1 ; i <= N ; i++) {
	        arr[i] = Integer.parseInt(br.readLine());
	    }
	    
	    visited = new boolean[N+1];
	    list = new ArrayList<>();
	    
	    for(int i = 1 ; i <= N ; i++) {
	        visited[i] = true;
	        dfs(i, i);
	        visited[i] = false;
	    }
	    
	    Collections.sort(list);
	    System.out.println(list.size());
	    for(int i : list) {
	        System.out.println(i);
	    }
	}
	
	private static void dfs(int idx, int target) {
	    if(arr[idx] == target) {
	        list.add(target);
	    }
	    
        if(!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            dfs(arr[idx], target);
            visited[arr[idx]] = false;
        }
	}
}

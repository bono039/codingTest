import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static List<Integer>[] A;
    static boolean[] selected;
    
    static int diff = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    arr = new int[N + 1];
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 1 ; i <= N ; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    A = new ArrayList[N+1];
	    for(int i = 1 ; i <= N ; i++) {
	        A[i] = new ArrayList<>();
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
	        String[] str = br.readLine().split(" ");
	        
	        int cnt = Integer.parseInt(str[0]);
	        
	        for(int j = 1 ; j < str.length ; j++) {
	            int num = Integer.parseInt(str[j]);
	            A[i].add(num);
	            A[num].add(i);
	        }
	    }
	    
	    selected = new boolean[N+1];
	    dfs(1, 0);
	    System.out.println(diff == Integer.MAX_VALUE ? -1 : diff);
	}
	
	private static void dfs(int idx, int depth) {
	    if(idx == N) {	        
	        ArrayList<Integer> list1 = new ArrayList<>();
	        ArrayList<Integer> list2 = new ArrayList<>();

	        for(int i = 1 ; i <= N ; i++) {
	            if(selected[i])
	                list1.add(i);
	            else
	                list2.add(i);
	        }
            
	        if(list1.size() == 0 || list2.size() == 0)  return;
	        if(!isConnected(list1) || !isConnected(list2))  return;
	        
	        int sum1 = 0;
	        int sum2 = 0;
	        for(int x : list1)  sum1 += arr[x];
	        for(int x : list2)  sum2 += arr[x];
	        
    	    diff = Math.min(diff, Math.abs(sum1 - sum2));
	        return;
	    }
	    
	    dfs(idx + 1, depth);
        
	    selected[idx] = true;
	    dfs(idx + 1, depth + 1);
	    selected[idx] = false;
	}
	
	private static boolean isConnected(List<Integer> list) {
	    boolean[] visited = new boolean[N+1];
	    visited[list.get(0)] = true;
        
	    Queue<Integer> q = new ArrayDeque<>();
	    q.add(list.get(0));
	    
	    while(!q.isEmpty()) {
	        int now = q.poll();
	        
	        for(int next : A[now]) {
	            if(!visited[next] && list.contains(next)) {
	                visited[next] = true;
	                q.add(next);
	            }
	        }
	    }
	    
	    for(int num : list) {
	        if(!visited[num])
	            return false;
	    }
	    
	    return true;
	}
}

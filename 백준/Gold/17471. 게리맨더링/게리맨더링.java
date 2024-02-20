import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    
    static List<Integer>[] A;
    static boolean[] visited;
    
    static int min = Integer.MAX_VALUE;
    static boolean canDivide = false;
    
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    arr = new int[N+1];
	    visited = new boolean[N+1];
	    
	    A = new ArrayList[N+1];
	    for(int i = 1 ; i <= N ; i++) {
	        A[i] = new ArrayList<>();
	    }
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 1 ; i <= N ; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
	        String[] str = br.readLine().split(" ");
	        for(int j = 1 ; j < str.length ; j++) {
	            int num = Integer.parseInt(str[j]);
	            
	            A[i].add(num);
	            A[num].add(i);
	        }
	    }
	    
	    dfs(0);
	    
	    if(min == Integer.MAX_VALUE) {
	        min = -1;
	    }
	    
	    System.out.println(min);
	}
	
	private static void dfs(int idx) {
	    if(idx == N) {	        
	        List<Integer> group1 = new ArrayList<>();
	        List<Integer> group2 = new ArrayList<>();
	        
	        for(int i = 1 ; i <= N ; i++) {
	            if(visited[i])
	                group1.add(i);
	            else
	                group2.add(i);
	        }
	        
	        if(group1.size() == 0 || group2.size() == 0)
	            return;
	        
	        if(bfs(group1) &&  bfs(group2))
	            getDiff();
	        
	        return;
	    }
	    
	    visited[idx] = true;
	    dfs(idx + 1);
	    
	    visited[idx] = false;
	    dfs(idx + 1);
	}
	
	private static boolean bfs(List<Integer> list) {
	    Queue<Integer> q = new ArrayDeque<>();
	    q.add(list.get(0));
	    
	    boolean[] chk = new boolean[N+1];
	    chk[list.get(0)] = true;
	    
	    while(!q.isEmpty()) {
	        int now = q.poll();
	        
	        for(int next : A[now]) {
	            if(list.contains(next) && !chk[next]) {
	                chk[next] = true;
	                q.add(next);
	            }
	        }
	    }
	    
	    for(int i : list) {
	        if(!chk[i]) {
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	private static void getDiff() {
	    int sum1 = 0;
	    int sum2 = 0;
	    
	    for(int i = 1 ; i <= N ; i++) {
	        if(visited[i])  sum1 += arr[i];
	        else            sum2 += arr[i];
	    }
	    
	    int diff = (int)Math.abs(sum1 - sum2);
	    min = Math.min(min, diff);
	}
}

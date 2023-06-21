import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] answer;
	static int max = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = new ArrayList<>();
		}
		
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		
		while(M --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    
		    A[s].add(e);
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    visited = new boolean[N + 1];
		    bfs(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= N ; i++) {
    	    if(answer[i] == max) {
    	        sb.append(i).append(" ");
    	    }
		}
		System.out.println(sb);
	}
	
	static void bfs(int num) {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(num);
	    visited[num] = true;
	    
	    while(!queue.isEmpty()) {
	        int now = queue.poll();
	        
	        for(int next : A[now]) {
	            if(!visited[next]) {
	                visited[next] = true;
	                answer[next]++;
	                queue.add(next);
	                max = Math.max(max, answer[next]);
	            }
	        }
	    }
	}
}

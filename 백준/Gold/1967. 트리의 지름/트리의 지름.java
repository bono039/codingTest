import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Node>[] list;
    static boolean[] visited;
    static int answer = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    list = new ArrayList[N+1];
	    for(int i = 0 ; i <= N ; i++)
	        list[i] = new ArrayList<>();
	    
	    for(int i = 0 ; i < N-1 ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
	        int v = Integer.parseInt(st.nextToken());
	        
	        list[from].add(new Node(to, v));
	        list[to].add(new Node(from, v));
	    }
	    
	    for(int i = 1 ; i <= N ; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
	    }
	    
	    System.out.println(answer);
	}
	
	private static void dfs(int idx, int sum) {
	    answer = Math.max(answer, sum);
	    
        for(Node next : list[idx]) {
            if(!visited[next.idx]) {
                visited[next.idx] = true;
                dfs(next.idx, sum + next.v);
                visited[next.idx] = false;       
            }
        }
	}
}

class Node {
    int idx, v;
    
    public Node(int idx, int v) {
        this.idx = idx;
        this.v = v;
    }
}

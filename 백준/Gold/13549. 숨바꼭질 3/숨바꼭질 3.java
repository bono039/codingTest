import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int time = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N >= K) {
		    System.out.println(N - K);
		} else {
		    System.out.println(bfs());
		}
	}
	
	static int bfs() {
        Queue<Node> queue = new LinkedList<>();
	    queue.add(new Node(N, 0));
	    visited[N] = true;
	    
	    while(!queue.isEmpty()) {
            Node now = queue.poll();
           
            if(now.x == K) {
                return time = Math.min(time, now.time);
            }
           
            int next;
            next = now.x * 2;
            if(next < 100001 && !visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, now.time));
            }
            
            next = now.x - 1;
            if(next >= 0 && !visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, now.time + 1));
            }
            
            next = now.x + 1;
            if(next < 100001 && !visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, now.time + 1));
            }
	    }
	    return 0;
	}
}

class Node {
    int x, time;
    
    Node(int x, int time) {
        this.x = x;
        this.time = time;
    }
}
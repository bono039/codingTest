import java.util.*;
import java.io.*;
public class Main {
    static int S;
    static boolean[][] visited = new boolean[1001][1001];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Integer.parseInt(br.readLine());
		bfs();
	}
	
	static void bfs() {
	    Queue<Node> queue = new LinkedList<>();
	    queue.add(new Node(0, 1, 0));
	    visited[0][1] = true;
	    
	    while(!queue.isEmpty()) {
	        Node now = queue.poll();
	        
	        if(now.total == S) {
	            System.out.println(now.time);
	            return;
	        }
	        
	        queue.offer(new Node(now.total, now.total, now.time + 1));
	        
	        if(now.clipboard != 0 && now.total + now.clipboard <= S && !visited[now.clipboard][now.total + now.clipboard]) {
	            queue.offer(new Node(now.clipboard, now.total + now.clipboard, now.time + 1));
	            visited[now.clipboard][now.total + now.clipboard] = true;
	        }
	        
	        if(now.total >= 1 && !visited[now.clipboard][now.total - 1]) {
	            queue.offer(new Node(now.clipboard, now.total - 1, now.time + 1));
	            visited[now.clipboard][now.total - 1] = true;
	        }
	    }
	}
}
class Node {
    int clipboard, total, time;
    
    Node(int clipboard, int total, int time) {
        this.clipboard = clipboard;
        this.total = total;
        this.time = time;
    } 
}
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Node> q = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1 ; i <= N ; i++) {
		    q.add(new Node(i, Integer.parseInt(st.nextToken())));
		}
		
		while(!q.isEmpty()) {
		    sb.append(q.getFirst().idx + " ");
		    int next = q.poll().val;
		    
		    if(q.isEmpty()) break;
		    
		    if(next > 0) {
		        for(int i = 0 ; i < next - 1 ; i++) {
		            q.addLast(q.pollFirst());
		        }
		    }
		    else {
		        for(int i = 0 ; i < Math.abs(next) ; i++) {
		            q.addFirst(q.pollLast());
		        }
		    }
		}
        
        System.out.println(sb);
	}
}

class Node {
    int idx, val;
    
    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

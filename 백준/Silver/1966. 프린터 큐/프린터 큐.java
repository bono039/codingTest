import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int N = Integer.parseInt(st.nextToken());
		    int M = Integer.parseInt(st.nextToken());
		    
		    LinkedList<Node> q = new LinkedList<>();
		    
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int i = 0 ; i < N ; i++) {
		        q.add(new Node(i, Integer.parseInt(st.nextToken())));
		    }
		    
		    int cnt = 0;
		    
		    while(!q.isEmpty()) {
		        boolean isMax = true;
		        Node now = q.poll();
		        
		        for(int i = 0 ; i < q.size() ; i++) {
		            if(now.val < q.get(i).val) {
		                q.add(now);
		                
		                for(int j = 0 ; j < i ; j++) {
		                    q.add(q.poll());
		                }
		                
		                isMax = false;
		                break;
		            }
		        }
		        
		        
		        if(isMax) {
		            cnt++;
		            if(now.idx == M) break;
		        }
		    }
		    sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}

class Node  {
    int idx, val;
    
    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    List<Node> list = new ArrayList<>();
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        list.add(new Node(i + 1, Integer.parseInt(st.nextToken())));
	    }
	    
	    int pos = 0;
	    int len = 0;
	    
	    while(!list.isEmpty()) {
            len = list.get(pos).val;
    	    sb.append(list.get(pos).idx + " ");
    	    list.remove(pos);
    	    
    	    if(list.size() == 0) break;
    	    
    	    if(len >= 0) {
    	        pos = (pos + len - 1) % list.size();
    	    }
    	    else {
    	        pos = (pos + len) % list.size();
    	        
    	        if(pos < 0) pos += list.size();
    	    }
	    }
	    
	    System.out.println(sb.toString());
	}
}

class Node {
    int idx, val;
    
    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

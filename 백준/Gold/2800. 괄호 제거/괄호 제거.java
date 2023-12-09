import java.util.*;
import java.io.*;

public class Main {
    static char[] ch;
    
    static List<Node> brackets = new ArrayList<>();
    static Set<String> result = new TreeSet<>();
    static boolean[] check;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    ch = br.readLine().toCharArray();
	    Stack<Integer> stack = new Stack<>();
	    
	    for(int i = 0 ; i < ch.length ; i++) {
	        if(ch[i] == '(') {
	            stack.push(i);
	        }
	        else if(ch[i] == ')') {
	            brackets.add(new Node(stack.pop(), i));
	        }
	    }
	    
	    check = new boolean[ch.length];
	    comb(0);
	    
	    Iterator<String> iter = result.iterator();  // set을 iterator 안에 담기
	    while(iter.hasNext()) {
	        System.out.println(iter.next());
	    }
	}
	
	private static void comb(int depth) {
	    if(depth == brackets.size()) {
	        boolean b = false;
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0 ; i < ch.length ; i++) {
	            if(!check[i]) {
	                sb.append(ch[i]);
	            }
	            else {
	                b = true;
	            }
	        }
	        
	        if(b) {
	            result.add(sb.toString());
	        }
	        return;
	    }
	    
	    comb(depth + 1);
	    
	    Node now = brackets.get(depth);
	    check[now.num] = true;
	    check[now.idx] = true;
	    comb(depth + 1);
	    check[now.num] = false;
	    check[now.idx] = false;
	}
}

class Node {
    int num, idx;
    
    public Node(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}

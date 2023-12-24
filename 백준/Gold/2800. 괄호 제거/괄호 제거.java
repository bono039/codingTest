import java.util.*;
import java.io.*;

public class Main {
    static char[] ch;
    static Stack<Integer> st;
    
    static List<int[]> list = new ArrayList<>();
    static boolean[] visited;
    
    static Set<String> result = new TreeSet<>();
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    ch = br.readLine().toCharArray();
	    
	    st = new Stack<>();
	    
	    for(int i = 0 ; i < ch.length ; i++) {
	        if(ch[i] == '(') {
	            st.push(i);
	        }
	        else if(ch[i] == ')') {
	            list.add(new int[] {st.pop(), i});
	        }
	    }
	    
	    visited = new boolean[ch.length];
	    comb(0);
	    
	    for(String s : result) {
	        sb.append(s).append("\n");
	    }
	    System.out.println(sb);
	}
	
	private static void comb(int depth) {
	    if(depth == list.size()) {
	        StringBuilder tmp = new StringBuilder();
	        boolean b = false;
	        
	        for(int i = 0 ; i < ch.length ; i++) {
	            if(!visited[i]) {
	                tmp.append(ch[i]);
	            }
	            else {
	                b = true;
	            }
	        }
	        
	        if(b) {
	            result.add(tmp.toString());
	        }
	        
	        return;
	    }
	    
	    comb(depth + 1);
	    
	    int[] now = list.get(depth);
	    visited[now[0]] = true;
	    visited[now[1]] = true;
	    comb(depth + 1);
	    visited[now[0]] = false;
	    visited[now[1]] = false;	    
	}
}

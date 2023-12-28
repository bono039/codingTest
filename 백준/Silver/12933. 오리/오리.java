import java.util.*;
import java.io.*;

public class Main {
    static char[] duck = {'q', 'u', 'a','c', 'k'};
    
    static char[] ch;
    static boolean[] visited;
    
    static int idx = 0;
    static int cnt = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ch = br.readLine().toCharArray();
		visited = new boolean[ch.length];
		
		if(ch[0] != 'q' || ch.length % 5 != 0) {
		    System.out.println(-1);
		    return;
		}
		
		for(int i = 0 ; i < ch.length ; i++) {
		    List<Character> list = new ArrayList<>();
		    
		    for(int j = i ; j < ch.length ; j++) {
		        if(!visited[j] && ch[j] == duck[idx]) {
		            idx++;
		            list.add(ch[j]);
		            visited[j] = true;
		            
		            if(idx == 5) {
		                idx = 0;
		            }
		        }
		    }
		    
		    if(list.size() != 0) {
		        if(list.get(list.size() - 1) != 'k') {
		            System.out.println(-1);
		            return;
		        }
		        
		        cnt++;
		    }
		}
		
		System.out.println(cnt);
	}
}

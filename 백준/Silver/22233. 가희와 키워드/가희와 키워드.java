import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    HashMap<String, Integer> map = new HashMap<>();
	    for(int i = 0 ; i < N ; i++) {
	        String s = br.readLine();
	        map.put(s, 1);
	    }
	    
	    for(int i = 0 ; i < M ; i++) {
	        String[] str = br.readLine().split(",");
	        for(String s : str) {
	            if(map.containsKey(s) && map.get(s) == 1) {
	                N--;
	                map.put(s, 0);
	            }
	        }
	        
	        sb.append(N).append("\n");
	    }
	    System.out.println(sb.toString());
	}
}
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < N ; i++) {
		    String str = br.readLine();
		    
		    char ch = str.charAt(0);
		    map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		
		// 키랑 값 가져오기
		Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
		
		while(iter.hasNext()) {
		    Map.Entry<Character, Integer> entry = iter.next();
		    
		    if(entry.getValue() >= 5) {
		        sb.append(entry.getKey());
		    }
		}

				    
	    if(sb.length() == 0) {
	        sb.append("PREDAJA");
	    }
		System.out.println(sb);
	}
}
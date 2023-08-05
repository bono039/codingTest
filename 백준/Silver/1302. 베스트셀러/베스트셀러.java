import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int max = 0;
		
		Map<String, Integer> map = new HashMap<>();
		while(N --> 0) {
		    String str = br.readLine();
		    map.put(str, map.getOrDefault(str, 0) + 1);
		    max = Math.max(max, map.get(str));
		}
		
		List<String> list = new ArrayList<>();
		for(Map.Entry<String, Integer> e : map.entrySet()) {
		    if(e.getValue() == max) {
		        list.add(e.getKey());
		    }
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}

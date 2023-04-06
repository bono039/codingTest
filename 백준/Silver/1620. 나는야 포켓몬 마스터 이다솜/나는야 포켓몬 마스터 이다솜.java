import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();

		for(int i = 1 ; i <= n ; i++) {
		    String s = br.readLine();
		    String num = Integer.toString(i);
		    map.put(s, num);
		    map.put(num, s);
		}
		
		for(int i = 0; i < m ; i++) {
		    String str = br.readLine();
		    sb.append(map.get(str)).append("\n");
		}
		
		System.out.println(sb);
	}
}
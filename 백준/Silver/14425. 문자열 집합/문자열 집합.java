import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());   // 집합 S
		int m = Integer.parseInt(st.nextToken());   // 검사해야 하는 문자열들
		
		Set<String> set = new HashSet<>();    // 집합 S
		
		for(int i = 0 ; i < n ; i++) {
		    set.add(br.readLine());
		}
		
		int cnt = 0;
		for(int i = 0 ; i < m ; i++) {
		    String str = br.readLine();
		    
		    if(set.contains(str))
		        cnt++;
		}
		
		System.out.println(cnt);
	}
}
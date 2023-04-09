import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int cnt = 0;    // 듣도 보도 못한
		
		// 듣도 못한
		Set<String> set = new HashSet<>();
		for(int i = 0 ; i < N ; i++) {
		    set.add(br.readLine());
		}
		
		// 보도 못한
		List<String> list = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
		    String s = br.readLine();
		    if(set.contains(s)) {
		       list.add(s);
		    }
		}
		
		Collections.sort(list); // 정렬
		
		System.out.println(list.size());
		for(String name : list) {
		    System.out.println(name);
		}
	}
}
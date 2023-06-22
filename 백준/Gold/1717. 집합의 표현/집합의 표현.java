import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		for(int i = 1 ; i <= n ; i++) {
		    parent[i] = i;
		}
		
		while(m --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    
		    int num = Integer.parseInt(st.nextToken());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    if(num == 0) {
		        union(a, b);
		    }
		    else {
		        sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
		    }
		}
		System.out.println(sb);
	}
	
	static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b)  parent[b] = a;
	}
	
	static int find(int a) {
	    if(a == parent[a])  return a;
	    return parent[a] = find(parent[a]);
	}
}

import java.util.*;
import java.io.*;
public class Main {
    static int[] parent;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		
		// 배열 채우기
		for(int i = 1 ; i <= n ; i++) {
		    parent[i] = i;
		}
		
		// 입력 받기
		for(int i = 0 ; i < m ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    
		    int uf = Integer.parseInt(st.nextToken());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    // UNION 진행
		    if(uf == 0) {
		        union(a, b);
		    }
		    else {
		        if(checkSame(a, b)) System.out.println("YES");
		        else                System.out.println("NO");
		    }
		}
	}
	
	// UNION
	public static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b) {
	        parent[b] = a;
	    }
	}
	
	// FIND
	public static int find(int a) {
	    if(a == parent[a])  return a;
	    else                return parent[a] = find(parent[a]); // 경로 압축
	}
	
	// 두 원소가 같은 집합인지 확인
	public static boolean checkSame(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a == b) {
	        return true;
	    }
	    return false;
	}
}
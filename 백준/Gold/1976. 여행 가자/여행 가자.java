import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();    // 도시 수
		int m = sc.nextInt();    // 여행 계획 도시 수
		
		// 도시 연결 데이터 저장
		int[][] city = new int[n + 1][n + 1];   // 인접 행렬
		for(int i = 1 ; i <= n ; i++) {
		    for(int j = 1 ; j <= n ; j++) {
		        city[i][j] = sc.nextInt();
		    }
		}
		
		// 여행 계획
		int[] route = new int[m + 1];
		for(int i = 1 ; i <= m ; i++) {
		    route[i] = sc.nextInt();
		}
		
		// 대표 노드 자기 자신으로 초기화
		parent = new int[n + 1];
		for(int i = 1 ; i <= n ; i++) {
		    parent[i] = i;
		}
		
		// 인접 행렬에서 도시가 연결되어 있으면 union
		for(int i = 1 ; i <= n ; i++) {
		    for(int j = 1 ; j <= n ; j++) {
		        if(city[i][j] == 1) union(i,j);
		    }
		}
		
		// 여행 계획 도시들이 1개의 대표 도시로 연결돼 있는지 확인
		int idx = find(route[1]);
		for(int i = 2 ; i < route.length ; i++) {
		    if(idx != find(route[i])) {
		        System.out.println("NO");
		        return;
		    }
		}
		System.out.println("YES");
	}
	
	public static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b)
	        parent[b] = a;
	}
	public static int find(int a) {
	    if(a == parent[a]) return a;
	    else               return parent[a] = find(parent[a]);
	}
}
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parent;
    static int[][] map;
    static int[] plan;
    static boolean isPossible;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());    // 도시 수
		M = Integer.parseInt(br.readLine());    // 여행 계획에 속한 도시들 수
		
		// 각종 배열, 변수 초기화하기

		parent = new int[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    parent[i] = i;
		}

		isPossible = true;
		
		
		// N개 줄 연결 정보 입력 받기
		map = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 1 ; j <= N ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		        
		        if(map[i][j] == 1) {
		            union(i,j);
		        }
		    }
		}

		
		// 여행 계획 입력 받기
		plan = new int[M + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1 ; i <= M ; i++) {
		    plan[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 여행 계획에서 find해서 모두 같은 집합일 때 (true) => YES
		// 조합?
		for(int i = 1 ; i < plan.length ; i++) {
		    if(find(plan[i]) != find(plan[1])) {
		        isPossible = false;
		        break;
		    }
		}
		System.out.println(isPossible ? "YES" : "NO");
	}
	
	static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b) parent[b] = a;
	}
	static int find(int a) {
	    if(a == parent[a]) return a;
	    return parent[a] = find(parent[a]);
	}
}

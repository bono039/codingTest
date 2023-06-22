import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    
    static int trueNum;     // 진실 아는 사람 수
    static int[] trueArr;   // 진실 아는 사람 배열
    
    static ArrayList<Integer>[] party;  // 파티 데이터
    static int cnt;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();   // 사람 수
		int M = sc.nextInt();   // 파티 수
		
		cnt = 0;
		trueNum = sc.nextInt(); // 진실 아는 사람 수
		
		// 진실 아는 사람 번호
		trueArr = new int[trueNum];
		for(int i = 0 ; i < trueNum ; i++) {
		    trueArr[i] = sc.nextInt();
		}
		
		// 부모 배열 초기화
		parent = new int[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    parent[i] = i;
		}
		
		// 각 파티마다 오는 사람 수 , 번호 입력 받기
		party = new ArrayList[M];
		for(int i = 0 ; i < M ; i++) {
		    party[i] = new ArrayList<Integer>();
		    
		    int party_size = sc.nextInt();
	        for(int j = 0 ; j < party_size ; j++) {
	            party[i].add(sc.nextInt());
	        }
		}
		
		// 인접 리스트 각 원소에 대해 union 수행 (= 각 파티에 참여한 사람 한 그룹으로 만들기)
		for(int i = 0 ; i < M ; i++) {
		    int first = party[i].get(0);
		    
		    for(int j = 1 ; j < party[i].size() ; j++) {
		        union(first, party[i].get(j));
		    }
		}
		
		// 각 파티의 대표노드 vs 진실을 아는 사람들의 대표 노드
		for(int i = 0 ; i < M ; i++) {
		    boolean isPossible = true;
		    int cur = party[i].get(0);  // 각 파티의 대표 노드
		    
		    for(int j = 0 ; j < trueArr.length ; j++) {
		        if(find(cur) == find(trueArr[j])) {
		            isPossible = false;
		            break;
		        }
		    }
		    
		    if(isPossible) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    
	    if(a != b) parent[b] = a;
	}
	static int find(int a) {
	    if(a == parent[a])  return a;
	    return parent[a] = find(parent[a]);
	}
}

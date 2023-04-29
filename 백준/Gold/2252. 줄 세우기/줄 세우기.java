import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		for(int i = 0 ; i <= N ; i++) {
		    A.add(new ArrayList<>());
		}
		
		int[] indegree = new int[N + 1];   // 진입 차수 배열
		while(M --> 0) {
		    st = new StringTokenizer(br.readLine()," ");
		    int S = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    
		    A.get(S).add(E);
		    indegree[E]++;
		}
		
		// 위상 정렬 수행
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
		    // 1. 진입 차수가 0인 노드 큐에 저장
		    if(indegree[i] == 0) {
		        queue.offer(i);
		    }
		}
		
		while(!queue.isEmpty()) {
		    // 2-1. 큐에서 데이터 poll해 해당 노드를 탐색 결과에 추가
		    int now = queue.poll();
		    System.out.print(now + " ");
		    
		    for(int target : A.get(now)) {
		        // 2-2. 해당 노드가 가리키는 노드의 진입 차 수 1씩 감소 
		        indegree[target]--;
		        
		        // 3. 감소했을 때 진입 차수가 0이 되는 노드를 큐에 추가
		        if(indegree[target] == 0) {
		            queue.offer(target);
		        }
		    }
		}
	}
}
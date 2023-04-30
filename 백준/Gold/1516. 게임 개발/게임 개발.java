import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();   
		for(int i = 0 ; i <= N ; i++) {
		    A.add(new ArrayList<>());
		}
		
		int[] indegree = new int[N + 1];    // 진입 차수 배열
		int[] time = new int[N + 1];    // 건물 생산 시간
		
		for(int i = 1 ; i <= N ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    time[i] = Integer.parseInt(st.nextToken());
		    
		    // 인접 리스트 초기화
		    while(true) {
		        int preTemp = Integer.parseInt(st.nextToken());
		        if(preTemp == -1) break;
		        A.get(preTemp).add(i);
		        indegree[i]++;
		    }
		}
		
		
		// 위상 정렬
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
		    if(indegree[i] == 0) {
		        queue.offer(i);
		    }
		}
		
		int[] result = new int[N + 1];  // 정답 리스트
		while(!queue.isEmpty()) {
		    int now = queue.poll();
		    
		    for(int next : A.get(now)) {
		        indegree[next]--;
		        
		        // 시간 업데이트 : Math.max(현재 저장된 값, 현재 출발 노드 + 비용)
		        result[next] = Math.max(result[next], result[now] + time[now]);
		        
		        if(indegree[next] == 0) {
		            queue.offer(next);
		        }
		    }
		}

		for(int i = 1 ; i <= N ; i++) {
		    System.out.println(result[i] + time[i]);
		}
	}
}
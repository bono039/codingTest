import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] A = new ArrayList[N + 1];  // 인접 리스트
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = new ArrayList<>();
		}
		
		int[] indegree = new int[N + 1];    // 진입 차수 배열
		int[] time = new int[N + 1];        // 건물 생산 시간
		
		for(int i = 1 ; i <= N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    time[i] = Integer.parseInt(st.nextToken());
		    
		    while(true) {
		        int idx = Integer.parseInt(st.nextToken());
		        if(idx == -1)   break;
		        A[idx].add(i);
		        indegree[i]++;
		    }
		}
		
		// 위상 정렬
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
	        if(indegree[i] == 0) {
	            queue.add(i);
	        }
		}
        
        int[] result = new int[N + 1];  // 정답 리스트
        
		while(!queue.isEmpty()) {
		    int now = queue.poll();
		    
		    for(int next : A[now]) {
		        indegree[next]--;
		        
		        // 시간 업데이트
		        result[next] = Math.max(result[next], result[now] + time[now]);
		        
		        if(indegree[next] == 0) {
		            queue.add(next);
		        }
		    }
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    sb.append(result[i] + time[i]).append("\n");
		}
		System.out.println(sb);
	}
}

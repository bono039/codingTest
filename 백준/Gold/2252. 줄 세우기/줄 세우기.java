import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());   // 학생 수
		int M = Integer.parseInt(st.nextToken());   // 키 비교 횟수
		
		ArrayList<Integer>[] A = new ArrayList[N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    A[i] = new ArrayList<>();
		}
		
		// 키 정보 입력받기
		int[] indegree = new int[N + 1];    // 진입 차수 배열
		while(M --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    A[a].add(b);    // 단방향
		    indegree[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>(); // 정렬 리스트
		for(int i = 1 ; i <= N ; i++) {
		    if(indegree[i] == 0) {
		        queue.offer(i);
		    }
		}
		
		while(!queue.isEmpty()) {
		    int now = queue.poll();
		    sb.append(now).append(" ");		    
		    
		    for(int next : A[now]) {
		        indegree[next]--;
		        
		        if(indegree[next] == 0) {
		            queue.offer(next);
		        }
		    }
		}
		
		System.out.println(sb);
	}
}

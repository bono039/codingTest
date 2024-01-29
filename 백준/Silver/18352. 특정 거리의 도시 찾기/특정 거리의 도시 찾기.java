import java.util.*;
import java.io.*;

public class Main {
    static int N,M,K,X;
    static List<Integer>[] list;
    
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] distance;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());   // 도시 개수
	    M = Integer.parseInt(st.nextToken());   // 도로 정보
	    K = Integer.parseInt(st.nextToken());   // 거리 정보
	    X = Integer.parseInt(st.nextToken());   // 출발 도시 번호
	    
	    list = new ArrayList[N + 1];
	    distance = new int[N + 1];
	    
	    for(int i = 1 ; i <= N ; i++) {
	        list[i] = new ArrayList<>();
	        distance[i] = -1;
	    }
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int A = Integer.parseInt(st.nextToken());
	        int B = Integer.parseInt(st.nextToken());
	        
	        list[A].add(B);
	    }
	    
	    bfs();
	    
	    StringBuilder sb = new StringBuilder();
	    boolean chk = false;
	    for(int i = 1 ; i <= N ; i++) {
	        if(distance[i] == K) {
	            sb.append(i).append("\n");
	            chk = true;
	        }
	    }
	    System.out.println(chk ? sb : -1);
	}
	
	private static void bfs() {
	    distance[X] = 0;
	    q.add(X);
	    
	    while(!q.isEmpty()) {
	        int now = q.poll();
	        
	        for(int next : list[now]) {
	            if(distance[next] == -1) {
	                distance[next] = distance[now] + 1;
	                q.add(next);
	            }
	        }
	    }
	}
}

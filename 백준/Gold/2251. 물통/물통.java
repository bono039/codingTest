import java.util.*;
import java.io.*;

public class Main {
    static int[] from = {0,0,1,1,2,2};
    static int[] to   = {1,2,0,2,0,1};
    static boolean[][] visited; // 방문 배열
    static boolean[] answer;    // 정답 배열
    static int[] now;           // A,B,C 값 저장 배열
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		now = new int[3];
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());
		
		visited = new boolean[201][201];
		answer = new boolean[201];
		
		bfs();
		
		for(int i = 0 ; i < answer.length ; i++) {
		    if(answer[i])
		        sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
	    Queue<AB> queue = new LinkedList<>();
	    queue.add(new AB(0, 0));
	    
	    visited[0][0] = true;
	    answer[now[2]] = true;
	    
	    while(!queue.isEmpty()) {
	        AB p = queue.poll();
	        
	        int A = p.A;
	        int B = p.B;
	        int C = now[2] - A - B;
	        
	        for(int d = 0 ; d < 6 ; d++) {
	            int[] next = {A, B, C};
	            
	            next[to[d]] += next[from[d]];
	            next[from[d]] = 0;
	            
	            // 물이 넘칠 때
	            if(next[to[d]] > now[to[d]]) {
	                next[from[d]] = next[to[d]] - now[to[d]];
	                next[to[d]] = now[to[d]];
	            }
	            
	            if(!visited[next[0]][next[1]]) {
	                visited[next[0]][next[1]] = true;
	                queue.add(new AB(next[0], next[1]));
	                
	                if(next[0] == 0) {
	                    answer[next[2]] = true;
	                }
	            }
	        }
	    }
	    
	}
}

class AB {
    int A;
    int B;
    
    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}

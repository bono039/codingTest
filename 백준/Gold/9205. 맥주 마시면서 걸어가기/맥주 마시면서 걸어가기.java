import java.util.*;
import java.io.*;

public class Main {
    static int T, N, sx, sy, dx, dy;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    while(T --> 0) {
	        N = Integer.parseInt(br.readLine());
	        
	        List<int[]> list = new ArrayList<>();
	        for(int i = 0 ; i < N+2 ; i++) {
	            st = new StringTokenizer(br.readLine(), " ");
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
	            
	            if(i == 0) {
	                sx = x;
	                sy = y;
	            }
	            else if(i == N+1) {
	                dx = x;
	                dy = y;
	            }
	            else {
	                list.add(new int[]{x,y});
	            }
	        }
	        
	        sb.append(bfs(list) ? "happy\n" : "sad\n");
	    }
	    System.out.println(sb.toString());
	}
	
	private static boolean bfs(List<int[] > list) {
        boolean[] visited = new boolean[N];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sx, sy});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            int px = now[0];
            int py = now[1];
            if(Math.abs(px-dx) + Math.abs(py-dy) <= 1000) {
                return true;
            }
            
            for(int i = 0 ; i < N ; i++) {
                if(!visited[i]) {
                    int nx = list.get(i)[0];
                    int ny = list.get(i)[1];
                    int dist = Math.abs(px-nx) + Math.abs(py-ny);
                    if(dist <= 1000) {
                        visited[i] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        return false;
    }
}
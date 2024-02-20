import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int R, C, T;
    static int[][] map;
    static Queue<int[]> dusts;
    static List<Integer> cleaner = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine() ," ");
	    
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    T = Integer.parseInt(st.nextToken());
	    
	    map = new int[R][C];
	    
	    for(int i = 0 ; i < R ; i++) {
	        st = new StringTokenizer(br.readLine() ," ");
	        for(int j = 0 ; j < C ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	            
	            if(map[i][j] == -1)
	                cleaner.add(i);
	        }
	    }
	    
	    while(T --> 0) {
	        diffuse();
	        work();
	    }
	    
	    calculate();
	}
	
	private static void diffuse() {
	    dusts = new ArrayDeque<>();
	    
	    for(int i = 0 ; i < R ; i++) {
	        for(int j = 0 ; j < C ; j++) {
	            if(map[i][j] != 0 && map[i][j] != -1)
	                dusts.add(new int[]{i, j, map[i][j]});
	        }
	    }
	    
	    while(!dusts.isEmpty()) {
	        int[] now = dusts.poll();
	        
	        if(now[2] < 5) continue;
	        
	        int cnt = 0;
	        int dust = now[2] / 5;
	        
	        for(int dir = 0 ; dir < 4 ; dir++) {
	            int nr = now[0] + dx[dir];
	            int nc = now[1] + dy[dir];
	            
                if(nr < 0 || nr >= R || nc < 0 || nc >= C)    continue;
	            if(map[nr][nc] == -1) continue;
	            
	            map[nr][nc] += dust;
	            ++cnt;
	        }
	        
	        map[now[0]][now[1]] -= dust * cnt;
	    }
	}

    private static void work() {
        int top = cleaner.get(0);
        for(int i = top - 1 ; i > 0 ; i--)    map[i][0] = map[i-1][0];
        for(int i = 0 ; i < C - 1 ; i++)    map[0][i] = map[0][i+1];
        for(int i = 0 ; i < top ; i++)    map[i][C-1] = map[i+1][C-1];
        for(int i = C - 1 ; i > 1 ; i--)    map[top][i] = map[top][i-1];
        map[top][1] = 0;
                
        int down = cleaner.get(1);
        for(int i = down + 1 ; i < R - 1 ; i++)    map[i][0] = map[i+1][0];
        for(int i = 0 ; i < C - 1 ; i++)    map[R-1][i] = map[R-1][i+1];
        for(int i = R - 1 ; i > down ; i--)    map[i][C-1] = map[i-1][C-1];
        for(int i = C - 1 ; i > 1 ; i--)    map[down][i] = map[down][i-1];
        map[down][1] = 0;
    }
		
	private static void calculate() {
	    int total = 0;
	    
	    for(int[] i : map)
	        for(int j : i) {
	            if(j == -1) continue;
	            total += j;
	        }
	    
	    System.out.println(total);
	}
}

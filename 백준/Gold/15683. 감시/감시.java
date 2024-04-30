import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int[][][] mode = {{{0}},
                             {{0}, {1}, {2}, {3}}, {{2,3}, {0,1}}, 
                             {{0,3}, {1,3}, {1,2}, {0,2}},
                             {{0,2,3}, {0,1,3}, {1,2,3}, {0,1,2}},
                             {{0,1,2,3}}};
    
    static int N,M;
    static int[][] map;
    static int zeroCnt = 0;
    
    static List<CCTV> list = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine(),  " ");
		    for(int j = 0 ; j < M ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		        
		        if(map[i][j] == 0)
		            zeroCnt++;
		        else if(map[i][j] >= 1 && map[i][j] <= 5)
		            list.add(new CCTV(i, j, map[i][j]));
		    }
		}
		
		answer = zeroCnt;
		dfs(0, list.size(), map);
		System.out.println(answer);
	}
	
	private static void dfs(int depth, int r, int[][] map) {
	    if(depth == r) {
	        int cnt = check(map);
	        answer = Math.min(answer, cnt);
	        return;
	    }
	    
	    CCTV now = list.get(depth);
	    int num = now.num;
	    int rr = now.r;
	    int cc = now.c;
	    
	    for(int i = 0 ; i < mode[num].length ; i++) {
	        int[][] copy = new int[N][M];
	        for(int a = 0 ; a < N ; a++) {
	            for(int b = 0 ; b < M ; b++)
	                copy[a][b] = map[a][b];
	        }
	        
	        for(int j = 0 ; j < mode[num][i].length ; j++) {
	            int dir = mode[num][i][j];
	            
	            int nr = rr + dr[dir];
	            int nc = cc + dc[dir];
	            
	            while(true) {
	                if(nr < 0 || nr >= N || nc < 0 || nc >= M)  break;
	                if(map[nr][nc] == 6)    break;
	                
	                copy[nr][nc] = -1;
	                nr += dr[dir];
	                nc += dc[dir];
	            }
	        }
	        
	        dfs(depth + 1, r, copy);
	    }
	}
	
	private static int check(int[][] map) {
	    int cnt = 0;
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(map[i][j] == 0)
	                cnt++;
	        }
	    }
	    
	    return cnt;
	}
}

class CCTV {
    int r, c, num;
    
    public CCTV(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }
}
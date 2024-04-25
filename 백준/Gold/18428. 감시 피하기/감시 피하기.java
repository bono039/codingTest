import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N;
    static char[][] map;
    static List<int[]> sList = new ArrayList<>();
    static List<int[]> tList = new ArrayList<>();
    static List<int[]> list = new ArrayList<>();
    static boolean[] chk;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 0 ; j < N ; j++) {
		        map[i][j] = st.nextToken().charAt(0);
		        
		        if(map[i][j] == 'S')         sList.add(new int[] {i, j});
		        else if(map[i][j] == 'T')    tList.add(new int[] {i, j});
		        else if(map[i][j] == 'X')    list.add(new int[] {i, j});
		    }
		}
		
		chk = new boolean[list.size()];
		dfs(0,0);
		System.out.println("NO");
	}
	
	private static void dfs(int idx, int cnt) {
	    if(cnt == 3) {
	        bfs();
	        return;
	    }
	    
	    for(int i = idx ; i < list.size() ; i++) {
	        if(!chk[i]) {
	            chk[i] = true;
	            dfs(i + 1, cnt + 1);
	            chk[i] = false;
	        }
	    }
	}
	
	private static void bfs() {
	    boolean[][] visited = new boolean[N][N];
	    Queue<int[]> q = new ArrayDeque<>();
	    
	    for(int i = 0 ; i < chk.length ; i++) {
	        if(chk[i]) {
	            int x = list.get(i)[0];
	            int y = list.get(i)[1];
	            map[x][y] = 'O';
	        }
	    }
	    
	    for(int[] x : tList) {
	        q.add(new int[] {x[0], x[1]});
	        visited[x[0]][x[1]] = true;
	    }
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
	            
	            while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
	                if(map[nx][ny] == 'O')  break;
	                
	                visited[nx][ny] = true;
	                nx += dx[d];
	                ny += dy[d];
	            }
	        }
	    }
	    
	    boolean isOK = true;
	    for(int[] s : sList) {
	        if(visited[s[0]][s[1]]) {
	            isOK = false;
	        }
	    }
	    
	    if(isOK) {
	        System.out.println("YES");
	        System.exit(0);
	    }
	    
	    for(int i = 0 ; i < chk.length ; i++) {
	        if(chk[i]) {
	            int x = list.get(i)[0];
	            int y = list.get(i)[1];
	            map[x][y] = 'X';
	        }
	    }
	}
}

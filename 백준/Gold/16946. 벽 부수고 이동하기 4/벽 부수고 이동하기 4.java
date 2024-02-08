import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static int N,M;
    static int[][] map, group;
    
    static Map<Integer, Integer> groupSize = new HashMap<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    group = new int[N][M];
	    
	    for(int i = 0 ; i < N ; i++) {
	        String str = br.readLine();
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = str.charAt(j) - '0';
	        }
	    }
	    
	    int groupCnt = 1;
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(map[i][j] == 0 && group[i][j] == 0) {
	                groupSize.put(groupCnt, bfs(i, j, groupCnt));
	                groupCnt++;
	            }
	        }
	    }
	    
	    print();
	}
	
	private static int count(int x, int y) {
	    int cnt = 1;
	    if(map[x][y] == 0)  return 0;
	    
	    Set<Integer> set = new HashSet<>();
	    
	    for(int d = 0 ; d < 4 ; d++) {
	        int nx = x + dx[d];
	        int ny = y + dy[d];
	        
	        if(!inRange(nx, ny) || group[nx][ny] == 0)  continue;
	        
	        set.add(group[nx][ny]);
	    }
	    
	    for(int size : set) {
	        cnt += groupSize.get(size);
	    }
	    
	    return cnt % 10;
	}
	
	private static int bfs(int x, int y, int groupCnt) {
	    int cnt = 1;
	    
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[]{x, y});
	    group[x][y] = groupCnt;
	    
	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        
	        for(int d = 0 ; d < 4 ; d++) {
	            int nx = now[0] + dx[d];
	            int ny = now[1] + dy[d];
                
	            if(canGo(nx, ny)) { // 
	                group[nx][ny] = groupCnt;
	                cnt++;
	                q.add(new int[]{nx, ny});
	            }
	        }
	    }
	    
	    return cnt;
	}
	
	private static boolean canGo(int x, int y) {
	    return (inRange(x, y) && group[x][y] == 0 && map[x][y] == 0);
	}
	
	private static boolean inRange(int x, int y) {
	    return (0 <= x && x < N && 0 <= y && y < M);
	}
	
	private static void print() {
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            if(group[i][j] == 0)  {
	                sb.append(count(i, j)+"");
	                continue;
	            }
	            sb.append(0+"");
	        }
	        sb.append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
}

import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int N,M;
    static int[][] map;
    static List<int[]> list = new ArrayList<>();
    static int[] cntArr = new int[3];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][N];
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < N ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    calcTornado();
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int d = Integer.parseInt(st.nextToken());
	        int s = Integer.parseInt(st.nextToken());
	        
	        destroy(d-1,s);
	        move();
	        
	        while(chkMarble())
	            move();
	            
	        changeMarble();
	    }
	    
	    System.out.println(cntArr[0] + 2*cntArr[1] + 3*cntArr[2]);
	}
	
	private static void destroy(int d, int s) {
        int r = N/2;
        int c = N/2;
	    
        for(int i = 0 ; i < s ; i++) {
            r += dr[d];
            c += dc[d];
            map[r][c] = 0;
        }
	}
	
	private static void move() {
	    Queue<Integer> q = new ArrayDeque<>();
	    for(int[] m : list) {
	        if(map[m[0]][m[1]] != 0)
	            q.add(map[m[0]][m[1]]);
	    }

	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++)
	            map[i][j] = 0;
	    }
	    
	    int idx = 0;
	    while(!q.isEmpty()) {
	        int num = q.poll();
	        map[list.get(idx)[0]][list.get(idx)[1]] = num;
	        idx++;
	    }
	}
	
	private static boolean chkMarble() {
	    Queue<int[]> tmp = new ArrayDeque<>();
	    Queue<int[]> removeList = new ArrayDeque<>();
	    
	    boolean canExplode = false;
	    int r = list.get(0)[0];
	    int c = list.get(0)[1];
	    int num = map[r][c];
	    int combo = 1;
	    
	    tmp.add(new int[]{r, c});
	    
	    for(int i = 1 ; i < list.size() ; i++) {
	        int nr = list.get(i)[0];
	        int nc = list.get(i)[1];
	        
	        if(map[nr][nc] == 0)    break;
	        
	        if(map[nr][nc] == num) {
	            combo++;
	            tmp.add(new int[]{nr, nc});
	        }
	        else {
	            if(combo >= 4) {
	                canExplode = true;
	                
	                while(!tmp.isEmpty()) {
	                    removeList.add(tmp.poll());
	                }
	            }
	            
	            num = map[nr][nc];
	            combo = 1;
	            tmp.clear();
	            tmp.add(new int[]{nr, nc});
	        }
	    }
	    
	    if(combo >= 4) {
	        canExplode = true;
	        
	        while(!tmp.isEmpty())
	            removeList.add(tmp.poll());
	    }

	    while(!removeList.isEmpty()) {
	        int[] now = removeList.poll();
	        
	        switch(map[now[0]][now[1]]) {
	            case 1: cntArr[0]++; break;
	            case 2: cntArr[1]++; break;
	            case 3: cntArr[2]++; break;
	        }
	        
	        map[now[0]][now[1]] = 0;
	    }
	    
	    return canExplode;
	}
	
	private static void changeMarble() {
	    Queue<int[]> q = new ArrayDeque<>();
	    
	    int num = map[list.get(0)[0]][list.get(0)[1]];
	    int combo = 1;
	    
	    for(int i = 1 ; i < list.size() ; i++) {
	        int nr = list.get(i)[0];
	        int nc = list.get(i)[1];

	        if(map[nr][nc] == 0) {
	            if(num != 0)
	                q.add(new int[] {combo, num});
	            break;
	        }
	        
	        if(map[nr][nc] == num)
	            combo++;
	        else {
	            q.add(new int[] {combo, num});
	            num = map[nr][nc];
	            combo = 1;
	        }
	    }
	    
	    if(q.size() == 0 && combo == 1) {
	        if(num != 0)
	            q.add(new int[] {combo, num});
	    }
	    
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++)
	            map[i][j] = 0;
	    }
	    
	    for(int i = 0 ; i < list.size() ; i += 2) {
	        int[] tmp1 = list.get(i);
	        int[] tmp2 = list.get(i+1);
	        
	        int nr1 = tmp1[0];
	        int nc1 = tmp1[1];
	        
	        int nr2 = tmp2[0];
	        int nc2 = tmp2[1];
	        
	        if(q.size() == 0)   break;
	        
	        int[] tmp = q.poll();
	        int tmpCombo = tmp[0];
	        int tmpNum = tmp[1];
	        
	        map[nr1][nc1] = tmpCombo;
	        map[nr2][nc2] = tmpNum;
	    }
	}
	
	private static void calcTornado() {
	    int[] tr = {0,1,0,-1};
	    int[] tc = {-1,0,1,0};
	    
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {N/2, N/2, 0, 0});
	    
	    int cnt = 0;
	    
	    while(true) {
	        int[] tmp = q.poll();
	        int r = tmp[0];
	        int c = tmp[1];
	        int dir = tmp[2];
	        int cycle = tmp[3];
	        
	        if(cnt % 2 == 0)
	            cycle++;
	        cnt++;
	        
	        for(int i = 0 ; i < cycle ; i++) {
	            int nr = r + tr[dir];
	            int nc = c + tc[dir];
	            
	            list.add(new int[] {nr, nc});
	            
	            if(nr == 0 && nc == 0)  return;
	            
	            r = nr;
	            c = nc;
	        }
	        
	        dir = (dir + 1) % 4;
	        q.add(new int[] {r, c, dir, cycle});
	    }
	}
}

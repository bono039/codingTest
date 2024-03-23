import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    static int N,M,K;
    static List<Fireball>[][] map;
    static List<Fireball> list = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    map = new ArrayList[N][N];
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++)
	            map[i][j] = new ArrayList<>();
	    }
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int r = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        int s = Integer.parseInt(st.nextToken());
	        int d = Integer.parseInt(st.nextToken());
	        
	        list.add(new Fireball(r-1,c-1,m,s,d));
	    }
	    
	    while(K --> 0) {
	        move();
	        fire();
	    }
	    
	    int answer = 0;
	    for(Fireball fb : list)
	        answer += fb.m;
	    
	    System.out.println(answer);
	}
	
	private static void move() {
	    for(Fireball fb : list) {
	        int nx = (fb.r + dx[fb.d] * (fb.s%N) + N) % N;
	        int ny = (fb.c + dy[fb.d] * (fb.s%N) + N) % N;
	        
	        fb.r = nx;
	        fb.c = ny;
	        
	        map[fb.r][fb.c].add(fb);
	    }
	}
	
	private static void fire() {
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(map[i][j].size() < 2) {
	                map[i][j].clear();
	                continue;
	            }
	            
	            int mSum = 0, sSum = 0;
	            int oddCnt = 0, evenCnt = 0;
	            int size = map[i][j].size();
	            
	            for(Fireball fb : map[i][j]) {
	                mSum += fb.m;
	                sSum += fb.s;
	                
	                if(fb.d % 2 == 1)   oddCnt++;
	                else                evenCnt++;
	                
	                list.remove(fb);
	            }
	            
	            map[i][j].clear();
	            mSum /= 5;
	            
	            if(mSum == 0)   continue;
	            
	            sSum /= size;
	            
	            if(oddCnt == size || evenCnt == size) {
	                for(int x = 0 ; x < 8 ; x += 2)
	                    list.add(new Fireball(i, j, mSum, sSum, x));
	            }
	            else {
	                for(int x = 1 ; x < 8 ; x += 2)
	                    list.add(new Fireball(i, j, mSum, sSum, x));
	            }
	        }
	    }
	}
}

class Fireball {
    int r, c, m, s, d;
    
    public Fireball(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

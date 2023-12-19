import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    static int N, M, K;
    static int[][] map, rotateArr, tmp;
    
    static boolean[] visited;
    static int[] numbers;
    static List<int[]> permList = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    map = new int[N + 1][M + 1];
	    for(int i = 1 ; i <= N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 1 ; j <= M ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    rotateArr = new int[K][3];
	    for(int i = 0 ; i < K ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        rotateArr[i][0] = Integer.parseInt(st.nextToken());
	        rotateArr[i][1] = Integer.parseInt(st.nextToken());
	        rotateArr[i][2] = Integer.parseInt(st.nextToken());
	    }
	    
	    numbers = new int[K];
	    visited = new boolean[K];
	    perm(0);
	    
	    for(int i = 0 ; i < permList.size() ; i++) {
	        tmp = new int[N + 1][M + 1];
	        
	        for(int r = 1 ; r <= N ; r++) {
	            for(int c = 1 ; c <= M ; c++) {
	                tmp[r][c] = map[r][c];
	            }
	        }
	        
	        int[] rotateInfo = permList.get(i);

	        for(int r : rotateInfo) {
	            rotate(rotateArr[r][0] , rotateArr[r][1], rotateArr[r][2]);
	        }
	        searchMinRowSum();
	    }
	    
	    System.out.println(min);
	}
	
	private static void perm(int depth) {
	    if(depth == K) {
	        permList.add(numbers.clone());
	        return;
	    }
	    
	    for(int i = 0 ; i < K ; i++) {
	        if(!visited[i]) {
    	        numbers[depth] = i;
    	        visited[i] = true;
    	        perm(depth + 1);
    	        visited[i] = false;
	        }
	    }
	}
	
	public static void rotate(int r, int c, int s) {
	    int sx = r-s;
	    int sy = c-s;
	    int ex = r+s;
	    int ey = c+s;

	    for(int i = 0 ; i < (ex - sx + 1) / 2 ; i++) {
	        
	        int firstX = sx + i;
	        int firstY = sy + i;
	        
	        int firstVal = tmp[firstX][firstY];
	        
	        int x = firstX;
	        int y = firstY;
	        
            int cnt = 0;
            while(cnt < 4) {
                int nx = x + dx[cnt];
                int ny = y + dy[cnt];
                
                if((sx + i <= nx) && (nx <= ex - i) && (sy + i <= ny) && (ny <= ey - i)) {
                    tmp[x][y] = tmp[nx][ny];
                    x = nx;
                    y = ny;
                }
                else {
                    cnt++;
                }
            }
            tmp[firstX][firstY + 1] = firstVal;
        
	    }
	}

	private static void searchMinRowSum() {
	    for(int i = 1 ; i <= N ; i++) {
	        int sum = 0;
	        
	        for(int j = 1 ; j <= M ; j++) {
	            sum += tmp[i][j];
	        }
	        
	        min = Math.min(min, sum);
	    }
	}
}

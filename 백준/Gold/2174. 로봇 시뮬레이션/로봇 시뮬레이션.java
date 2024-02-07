import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static int A, B, N, M;
    
    static int[][] map;
    static Robot[] robots;
    
    static boolean isTrue = false;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());
	    
	    map = new int[B + 1][A + 1];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());

	    robots = new Robot[N + 1];
	    
	    int d = 0;
	    for(int i = 1 ; i <= N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
    	    int x = Integer.parseInt(st.nextToken());
    	    int y = Integer.parseInt(st.nextToken());
    	    char dir = st.nextToken().charAt(0);
    	    
    	    if(dir == 'N')       d = 0;
    	    else if(dir == 'E')  d = 1;
    	    else if(dir == 'S')  d = 2;
    	    else if(dir == 'W')  d = 3;

    	    map[y][x] = i;    	    
    	    robots[i] = new Robot(x, y, d);
	    }
	    
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
    	    int num = Integer.parseInt(st.nextToken());
    	    char cmd = st.nextToken().charAt(0);
    	    int repeat = Integer.parseInt(st.nextToken());
    	    
    	    move(num, cmd, repeat);
    	    
    	    if(isTrue) {
    	        break;
    	    }
	    }
	    
	    if(!isTrue)
	        System.out.println("OK");   
	}
	
	private static void move(int num, char cmd, int repeat) {
	    while(repeat --> 0) {
    	    int x = robots[num].x;
    	    int y = robots[num].y;
    	    int d = robots[num].dir;
    	    
    	    if(cmd == 'L' || cmd == 'R') {
    	        int nd = getDir(d, cmd);
    	        robots[num].dir = nd;
    	    }
    	    else if(cmd == 'F') {
    	        int nx = x + dx[d];
    	        int ny = y + dy[d];
    	        
    	        if(!inRange(ny, nx)) {
    	            System.out.println("Robot " + num + " crashes into the wall");
    	            isTrue = true;
    	            return;
    	        }
    	        
    	        if(map[ny][nx] != 0) {
    	            System.out.println("Robot " + num + " crashes into robot " + map[ny][nx]);
    	            isTrue = true;
    	            return;
    	        }
    	        else {
    	            map[y][x] = 0;
    	            map[ny][nx] = num;
    	            
    	            robots[num].x = nx;
    	            robots[num].y = ny;
    	        }
    	    }       
	    }
	}
	
	private static int getDir(int dir, char cmd) {
	    if(cmd == 'L') {
	        if(dir == 0) dir = 3;
	        else         dir--;
	    }
	    else if(cmd == 'R') {
	        if(dir == 3)    dir = 0;
	        else            dir++;
	    }
	    
	    return dir;
	}
	
	private static boolean inRange(int y, int x) {
	    return (1 <= y && y <= B && 1 <= x && x <= A);
	}
}

class Robot {
    int x, y, dir;
    
    public Robot(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

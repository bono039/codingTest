import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};   // 북서남동 (0123)
    static int[] dy = {1, 0, -1, 0};
    
    static int A, B, N, M;
    
    static int[][] map;
    static Robot[] robots;
    
    static boolean isTrue = false;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    A = Integer.parseInt(st.nextToken());   // 가로
	    B = Integer.parseInt(st.nextToken());   // 세로
	    
	    map = new int[B + 1][A + 1];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    N = Integer.parseInt(st.nextToken());   // 로봇 수
	    M = Integer.parseInt(st.nextToken());   // 명령 수

	    // 각 로봇의 초기 좌표
	    robots = new Robot[N + 1];
	    
	    int d = 0;
	    for(int i = 1 ; i <= N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
    	    int x = Integer.parseInt(st.nextToken());   // x좌표
    	    int y = Integer.parseInt(st.nextToken());   // y좌표
    	    char dir = st.nextToken().charAt(0); // 방향
    	    
    	    if(dir == 'N')       d = 0;
    	    else if(dir == 'E')  d = 1;
    	    else if(dir == 'S')  d = 2;
    	    else if(dir == 'W')  d = 3;

    	    map[y][x] = i;    	    
    	    robots[i] = new Robot(x, y, d);
	    }
	    
	    // 명령 내리기
	    while(M --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
    	    int num = Integer.parseInt(st.nextToken());    // 명령 내리는 로봇
    	    char cmd = st.nextToken().charAt(0);           // 명령 종류
    	    int repeat = Integer.parseInt(st.nextToken()); // 명령 반복 횟수
    	    
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
    	        
    	        if(!inRange(nx, ny)) {
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
		
	private static boolean inRange(int x, int y) {
	    return (1 <= x && x <= A && 1 <= y && y <= B);
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

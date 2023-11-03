import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,1,-1,0};   // 동남북서 (행과 열 기준)
    static int[] dy = {1,0,0,-1};

    static int N, T, R, C;
    static char dir;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 격자 크기
        T = Integer.parseInt(st.nextToken());   // 시간
        map = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dir = st.nextToken().charAt(0);   // 방향

        int moveDir = getDir(dir);
        while(T --> 0) {
            int nx = R + dx[moveDir];
            int ny = C + dy[moveDir];

            if(!inRange(nx, ny)) {
                moveDir = 3 - moveDir;
            }
            else {  // 이동
                R += dx[moveDir];
                C += dy[moveDir];
            }
        }

        System.out.println(R + " " + C);
    }

    // 방향 가져오는 함수
    private static int getDir(char c) {
        if(c == 'R')    return 0;
        else if(c == 'D')   return 1;
        else if(c == 'U')   return 2;
        else                return 3;
    }

    // 범위 내에 있는지 확인하는 함수
    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= N);
    }
}

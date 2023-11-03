import java.util.*;
import java.io.*;

public class Main {
    static int max = 2000;  // = 100 * 10 * 2

    static int[] dx = {0,0,1,-1};   // 동서남북 (행과 열로 생각)
    static int[] dy = {1,-1,0,0,};

    static int N, dir;
    static int[][] map = new int[max + 1][max + 1];
    static int x = 500, y = 500; // 시작점
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            dir = getDir(st.nextToken().charAt(0));
            int dist = Integer.parseInt(st.nextToken());

            while(dist --> 0) {
                x += dx[dir];
                y += dy[dir];

                map[x][y] = time++; // 이동 시간 갱신

                // 시작점으로 돌아오면, 답 갱신
                if(x == 500 && y == 500) {
                    System.out.println(time);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    // 방향 구하는 메소드
    private static int getDir(char c) {
        if(c == 'E')       return 0;
        else if(c == 'W')   return 1;
        else if(c == 'S')   return 2;
        else                return 3;
    }
}

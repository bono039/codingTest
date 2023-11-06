import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};   // 서북동남 (행과 열로 생각)
    static int[] dy = {-1, 0, 1, 0};

    static int N;
    static int[][] map;
    static int x,y;
    static int dir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        x = N - 1;  y = N - 1;
        map[x][y] = N * N;

        for(int i = N * N - 1 ; i >= 1 ; i--) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx,ny) || map[nx][ny] != 0) {
                dir = (dir + 1) % 4;
            }

            x += dx[dir];
            y += dy[dir];
            map[x][y] = i;
        }

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for(int[] i : map) {
            for(int j : i) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 범위 판별 메소드
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}

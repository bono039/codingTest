import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1,0,-1,0};   // 남동북서 (행과 열로 생각)
    static int[] dy = {0,1,0,-1};

    static int n, m;
    static int[][] map;
    static int x = 0 , y = 0;   // 이동
    static int dir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        map[x][y] = 1;  // 초기 값 설정

        for(int i = 2 ; i <= n * m ; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 격자 범위 안에 들지 않거나, 방문한 적 있다면 회전
            if(!inRange(nx, ny) || (map[nx][ny] != 0)) {
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

    // 범위 벗어나는지 확인 함수
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }
}

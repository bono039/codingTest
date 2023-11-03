import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int N, M;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;

            sb.append(comfort(a, b) ? 1 : 0).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean comfort(int x, int y) {
        int cnt = 0;
        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 격자를 벗어나지 않고, 색칠되어 있는 칸인 경우
            if(inRange(nx, ny) && map[nx][ny] == 1) {
                cnt++;
            }
        }

        return (cnt == 3);
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= N);
    }
}

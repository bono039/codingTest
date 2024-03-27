import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int R,C;
    static char[][] map;
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0 ; i < R ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'X')
                    q.add(new int[] {i, j});
            }
        }

        int minR = R;
        int maxR = 0;
        int minC = C;
        int maxC = 0;

        while(!q.isEmpty()) {
            int cnt = 0;
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if(!inRange(nr, nc))
                    cnt++;
                else {
                    if(map[nr][nc] == '.') {
                        cnt++;
                    }
                }
            }

            if(cnt >= 3) {
                map[now[0]][now[1]] = '-';
            }
            else {
                minR = Math.min(minR, now[0]);
                minC = Math.min(minC, now[1]);
                maxR = Math.max(maxR, now[0]);
                maxC = Math.max(maxC, now[1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = minR ; i <= maxR ; i++) {
            for(int j = minC ; j <= maxC ; j++) {
                if(map[i][j] == '.' || map[i][j] == 'X')
                    sb.append(map[i][j]);
                else
                    sb.append('.');
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean inRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}

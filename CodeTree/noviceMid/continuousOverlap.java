import java.util.*;
import java.io.*;

public class Main {
    static final int OFFSET = 100;  // 음수 값에 대한 OFFSET 필요
  
    static int N, cnt;
    static char[][] map = new char[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) + OFFSET;
            int y1 = Integer.parseInt(st.nextToken()) + OFFSET;
            int x2 = Integer.parseInt(st.nextToken()) + OFFSET;
            int y2 = Integer.parseInt(st.nextToken()) + OFFSET;

            if(i % 2 == 0) {    // 빨간색
                paint(x1, y1, x2, y2, 'R');
            }
            else {  // 파란색
                paint(x1, y1, x2, y2, 'B');
            }
        }

        // 파란색 영역 넓이 구하기
        cnt = 0;
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                if(map[i][j] == 'B')
                    cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void paint(int x1, int y1, int x2, int y2, char c) {
        for(int i = x1 ; i < x2 ; i++) {
            for(int j = y1 ; j < y2 ; j++) {
                map[i][j] = c;
            }
        }
    }
}

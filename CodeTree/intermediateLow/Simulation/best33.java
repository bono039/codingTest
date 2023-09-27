import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;

        // 격자 범위 내에 있으면
        for (int i = 0 ; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                int cnt = 0; // 각 부분 격자에서 1의 개수를 세기 위해 초기화

                for (int m = i ; m < i + 3 && m < N; m++) {
                    for (int n = j ; n < j + 3 && n < N; n++) {
                        if (map[m][n] == 1) cnt++;
                    }
                }

                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N - 2 ; j++) {
                max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2]);
            }
        }
        
        System.out.println(max);
    }
}

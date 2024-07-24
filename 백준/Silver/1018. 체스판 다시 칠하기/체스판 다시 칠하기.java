import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++)
                paint(i, j);
        }
        
        System.out.println(min);
    }
    
    private static void paint(int x, int y) {
        int cnt1 = 0;
        int cnt2 = 0;
        
        for (int i = 0 ; i < 8 ; i++) {
            for (int j = 0 ; j < 8 ; j++) {
                if ((i+j) % 2 == 0) {
                    if(map[x+i][y+j] != 'B') cnt1++;
                    if(map[x+i][y+j] != 'W') cnt2++;
                }
                else {
                    if(map[x+i][y+j] != 'W') cnt1++;
                    if(map[x+i][y+j] != 'B') cnt2++;
                }
            }
        }
        
        min = Math.min(min, Math.min(cnt1, cnt2));
    }
}

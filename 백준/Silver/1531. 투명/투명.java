import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] pic = new int[101][101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int i = x1 ; i <= x2 ; i++) {
                for(int j = y1 ; j <= y2 ; j++) {
                    pic[i][j] += 1;
                }
            }
        }
        
        int ans = 0;
        for(int i = 1 ; i <= 100 ; i++) {
            for(int j = 1 ; j <= 100 ; j++) {
                if(pic[i][j] > M)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}

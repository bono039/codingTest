import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[][] pos = new int[3][2];
        
        for(int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        
        long tmp1 = (pos[0][0] * pos[1][1] + pos[1][0] * pos[2][1] + pos[2][0] * pos[0][1]);
        long tmp2 = (pos[1][0] * pos[0][1] + pos[2][0] * pos[1][1] + pos[0][0] * pos[2][1]);
        
        long ccw = tmp1 - tmp2;
        long answer = 0;
        
        if(ccw > 0) answer = 1;
        else if(ccw < 0) answer = -1;
        
        System.out.println(answer);
    }  
}

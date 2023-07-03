import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int earth = Integer.parseInt(st.nextToken());
        int sun = Integer.parseInt(st.nextToken());
        int moon = Integer.parseInt(st.nextToken());
        
        int E = 0;
        int S = 0;
        int M = 0;
        
        int answer = 0;
        
        while(true) {
            answer++;
            E++; S++; M++;
            
            if(E == 16) E = 1;
            if(S == 29) S = 1;
            if(M == 20) M = 1;
            if(earth == E && sun == S && moon == M) break;
        }
        
        System.out.println(answer);
    }
}
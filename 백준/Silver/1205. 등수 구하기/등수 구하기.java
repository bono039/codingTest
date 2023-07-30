import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        if(N == 0) {
            System.out.println(1);
            return;
        }
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        if(N == P && newScore <= A[A.length - 1]) {
            System.out.println(-1);
        }
        else {
            int rank = 1;
            for(int i = 0 ; i < A.length ; i++) {
                if(newScore < A[i]) {
                    rank++;
                }
                else {
                    break;
                }
            }
            
            System.out.println(rank);
        }  
    }
}
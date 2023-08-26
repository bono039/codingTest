import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] A;
    static boolean[] check;
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String str = br.readLine();
            
            if(str.equals("0")) {
                System.out.println(sb);
                break;
            }
            
            // 초기값 세팅
            String[] input = str.split(" ");
            N = Integer.parseInt(input[0]);
            A = new int[N];
            check = new boolean[N];
            
            for(int i = 0 ; i < N ; i++) {
                A[i] = Integer.parseInt(input[i + 1]);
            }
            
            back(0, 0);
            sb.append("\n");
        }
    }
    
    private static void back(int startIdx, int depth) {
        if(depth == 6) {
            for(int i = 0 ; i < N ; i++) {
                if(check[i]) {
                    sb.append(A[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        
        for(int i = startIdx ; i < N ; i++) {
            check[i] = true;
            back(i + 1 , depth + 1);
            check[i] = false;
        }
    }
}
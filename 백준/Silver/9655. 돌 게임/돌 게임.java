import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] rock = new String[1001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        if (N >= 1) {
            rock[1] = "SK";
        }
        if (N >= 2) {
            rock[2] = "CY";
        }
        
        dp();
        
        System.out.println(rock[N]);
    }
    
    static void dp() {
        for (int cnt = 3; cnt <= N; cnt++) {
            if (rock[cnt - 1].equals("SK") && (cnt + 3 == N || cnt + 1 == N)) {
                rock[cnt] = "CY";
            } else if (rock[cnt - 1].equals("CY") && (cnt + 3 == N || cnt + 1 == N)) {
                rock[cnt] = "SK";
            } else {
                if (rock[cnt - 1].equals("SK")) {
                    rock[cnt] = "CY";
                } else if (rock[cnt - 1].equals("CY")) {
                    rock[cnt] = "SK";
                }
            }
        }
    }
}
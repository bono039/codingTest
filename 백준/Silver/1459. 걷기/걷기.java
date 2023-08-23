import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        
        long tmp1, tmp2, tmp3;

        tmp1 = (X + Y) * W;
        
        tmp2 = 0;
        if((X + Y) % 2 == 0) {
            tmp2 = Math.max(X, Y) * S;
        }
        else {
            tmp2 = (Math.max(X, Y) - 1) * S + W;
        }

        tmp3 = (Math.min(X, Y)) * S + (Math.abs(X - Y)) * W;
        
        System.out.println(Math.min(tmp1, Math.min(tmp2, tmp3)));
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        while(N -- > 0) {
            for(int j = N ; j >= 0 ; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    } 
}
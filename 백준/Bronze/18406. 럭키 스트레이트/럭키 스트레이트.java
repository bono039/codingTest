import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        String s1 = str.substring(0, str.length() / 2);
        String s2 = str.substring(str.length() / 2);
        
        int sum1 = 0;
        int sum2 = 0;
        
        for(int i = 0 ; i < s1.length() ; i++) {
            sum1 += s1.charAt(i) - '0';
            sum2 += s2.charAt(i) - '0';
        }
        
        System.out.println(sum1 == sum2 ? "LUCKY" : "READY");
    }
}
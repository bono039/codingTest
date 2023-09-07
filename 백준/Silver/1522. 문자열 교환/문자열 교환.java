import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int min = Integer.MAX_VALUE;
        
        int aLen = 0;
        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == 'a')
                aLen++;
        }
        
        for(int i = 0 ; i < str.length() ; i++) {
            int bCnt = 0;
            
            for(int j = i ; j < aLen + i ; j++) {
                if(str.charAt(j % str.length()) == 'b')
                    bCnt++;
            }
            
            min = Math.min(min, bCnt);
        }
        
        System.out.println(min);
    }
}
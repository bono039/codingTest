import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        char[] ch = str.toCharArray();
        
        int zCnt = 0;
        int oCnt = 0;
        
        if(ch[0] == '0') zCnt++;
        else             oCnt++;
        
        for(int i = 1 ; i < ch.length ; i++) {
            if(ch[i - 1] != ch[i]) {
                if(ch[i] == '0')    zCnt++;
                else                oCnt++;
            }
        }
        
        System.out.println(Math.min(zCnt, oCnt));
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()) - 1;
        String standard = br.readLine();
        int sLen = standard.length();
        
        int[] alphabet = new int[26];
        for(int i = 0 ; i < sLen ; i++) {
            alphabet[standard.charAt(i) - 'A']++;
        }
        
        int ans = 0;
        
        while(N --> 0) {
            int[] tmp = alphabet.clone();
            
            String word = br.readLine();
            int wLen = word.length();
            
            int cnt = 0;
            for(int i = 0 ; i < wLen ; i++) {
                if(tmp[word.charAt(i) - 'A'] > 0) {
                    cnt++;
                    tmp[word.charAt(i) - 'A']--;
                }
            }
            
            if(sLen - 1 == wLen && cnt == wLen) {
                ans++;
            }
            else if(sLen == wLen) {
                if(cnt == sLen || cnt == sLen - 1)
                    ans++;
            }
            else if(sLen + 1 == wLen) {
                if(cnt == sLen)
                    ans++;
            }  
        }
        
        System.out.println(ans);
    }
}
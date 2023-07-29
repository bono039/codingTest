import java.util.*;
import java.io.*;

public class Main {
    static String[] vowel = {"a", "e", "i", "o", "u"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            boolean isAcceptable = true;
            String str = br.readLine();
            if(str.equals("end"))   break;
            
            if(!checkOne(str) || !checkTwo(str) || !checkThree(str)) {
                isAcceptable = false;
            }        

            if(isAcceptable) {
                sb.append("<"+str+"> is acceptable.").append("\n");
            }
            else {
                sb.append("<"+str+"> is not acceptable.").append("\n");
            }
        }
        System.out.println(sb);
    }
    
    private static boolean checkOne(String s) {
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                return true;
            }
        }
        return false;
    } 
    
    private static boolean checkTwo(String s) {
        if(s.length() < 3)  return true;
        
        boolean[] words = new boolean[s.length()];
        
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                words[i] = true;
            }
        }
        
        int cnt = 1;
        for(int i = 0 ; i < s.length() - 1 ; i++) {
            if(words[i] == words[i+1]) {
                cnt++;
            }
            else {
                cnt = 1;
            }
            
            if(cnt == 3) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean checkThree(String s) {
        for(int i = 0 ; i < s.length() - 1 ; i ++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                if(s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                    return false;
                }
            }
        }
        
        return true;
    }
}
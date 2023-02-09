import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String newAns = "";
        
        for(int i=0 ; i < s.length() ; i++) {
            if(countChar(s, s.charAt(i)) == 1) {
                answer += String.valueOf(s.charAt(i));
            }
        }
        
        String[] sArr = answer.split("");
        Arrays.sort(sArr);
        
        for(String str : sArr) {
            newAns += str;
        }
        
        return newAns;
    }
    
    public int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
    
}
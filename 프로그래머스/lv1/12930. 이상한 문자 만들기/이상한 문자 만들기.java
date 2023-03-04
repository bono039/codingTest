import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split(" ");
        
        for(int j=0 ; j < strArr.length ; j++) {
            
            String si = strArr[j];
            
            for(int i=0 ; i < si.length() ; i++) {
                String str = String.valueOf(si.charAt(i));
                if(i % 2 == 0) answer += str.toUpperCase();
                else           answer += str.toLowerCase();
            }
            
            answer += " ";
        }
        
        return answer.strip();
    }
}
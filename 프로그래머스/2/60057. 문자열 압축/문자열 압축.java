import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = 1;
        
        for(int i = 1 ; i <= s.length()/2 ; i++) {  
            StringBuilder result = new StringBuilder();
            String base = s.substring(0, i);    
            
            for(int j = i ; j <= s.length() ; j += i) {
                int endIdx = Math.min(j + i, s.length());   
                
                String nextStr = s.substring(j, endIdx);
                
                if(base.equals(nextStr)) {
                    len++;
                }
                else {
                    if(len >= 2) {
                        result.append(len);
                    }
                    result.append(base);
                    base = nextStr; 
                    len = 1;        
                }
            }
            result.append(base);    
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}
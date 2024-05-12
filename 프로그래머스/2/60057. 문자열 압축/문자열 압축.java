import java.util.*;

class Solution {    
    public int solution(String s) {
        int answer = s.length();
        int len = 1;
        
        for(int i = 1 ; i <= s.length() / 2 ; i++) {  
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0,i);
            
            for(int j = i ; j <= s.length() ; j += i) {
                int eIdx = Math.min(j+i, s.length());
                String next = s.substring(j, eIdx);
                
                if(base.equals(next)) {
                    len++;
                }
                else {
                    if(len >= 2) {
                        sb.append(len);
                    }
                    
                    sb.append(base);
                    base = next;
                    len = 1;
                }
            }
            
            sb.append(base);
            answer = Math.min(answer, sb.length());
        }       
        
        return answer;
    }
}
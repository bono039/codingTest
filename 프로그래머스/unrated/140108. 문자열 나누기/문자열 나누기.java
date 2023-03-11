import java.util.*;

class Solution {
    public int solution(String s) {
        char first = s.charAt(0);
        
        int yes = 0;
        int no = 0;
        
        int answer = 0;
        
        for(int i=0 ; i < s.length() ; i++) {  
            if(yes == no) {
                answer++;
                first = s.charAt(i);
            }
            
            if(s.charAt(i) == first) yes++;
            else                     no++;
        }
        
        
        return answer;
    }
}
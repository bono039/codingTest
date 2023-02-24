import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] str = s.split("");
        
        Arrays.sort(str, Collections.reverseOrder());
        
        String answer = "";
        
        for(String i : str) {
            answer += i;
        }
        
        return answer;
    }
}
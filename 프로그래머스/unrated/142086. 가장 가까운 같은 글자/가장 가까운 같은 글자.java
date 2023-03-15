import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
                
        for(int i=1 ; i < s.length() ; i++) {
            int x = s.lastIndexOf(s.substring(i, i+1), i-1);
            
            answer[i] = (x == -1) ? x : (i - x);
        }
        
        return answer;
    }
}
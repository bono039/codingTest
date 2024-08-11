import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;    
        int len = name.length();
        int move = len-1;
        
        int idx;
        
        for(int i = 0 ; i < len ; i++) {
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
            
            idx = i+1;
            
            while(idx < len && name.charAt(idx) == 'A') {
                idx++;
            }
            
            move = Math.min(move, i*2 + len - idx);
            move = Math.min(move, (len - idx)*2 + i);
        }
        
        return answer + move;
    }
}